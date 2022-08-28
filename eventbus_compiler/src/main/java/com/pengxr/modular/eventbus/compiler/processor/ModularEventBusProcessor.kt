package com.pengxr.modular.eventbus.compiler.processor

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.serializer.SerializerFeature
import com.google.auto.service.AutoService
import com.pengxr.modular.eventbus.compiler.model.EventGroupDoc
import com.pengxr.modular.eventbus.compiler.model.EventGroupMeta
import com.pengxr.modular.eventbus.compiler.model.EventMeta
import com.pengxr.modular.eventbus.compiler.utils.*
import com.pengxr.modular.eventbus.facade.annotation.EventGroup
import com.squareup.javapoet.*
import java.util.*
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.element.Element
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeKind
import javax.lang.model.type.TypeMirror

/**
 * __   __  _____               ____    _____    ______   _   _    _____
 * \ \ / / |_   _|     /\      / __ \  |  __ \  |  ____| | \ | |  / ____|
 *  \ V /    | |      /  \    | |  | | | |__) | | |__    |  \| | | |  __
 *   > <     | |     / /\ \   | |  | | |  ___/  |  __|   | . ` | | | |_ |
 *  / . \   _| |_   / ____ \  | |__| | | |      | |____  | |\  | | |__| |
 * /_/ \_\ |_____| /_/    \_\  \____/  |_|      |______| |_| \_|  \_____|
 *
 * A processor used for find events and generated EventsDefine file.
 * <p>
 * Created by pengxr on 10/8/2022
 */
@AutoService(Processor::class)
class ModularEventBusProcessor : BaseProcessor() {

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment): Boolean {
        if (!annotations.isNullOrEmpty()) {
            logger.info(">>> Found events, start...<<<")
            try {
                // 1. Find elements annotated with @EventGroup
                val groupElements = roundEnv.getElementsAnnotatedWith(EventGroup::class.java)
                // 2. Collect information of elements found.
                val groupMetas = collectAnnotationMetas(groupElements)
                // 3. Generate EventsDefine file.
                generateJavaFiles(groupMetas)
                // 4. Generate Doc File.
                generateDocFiles(groupMetas)
            } catch (e: Exception) {
                logger.error(e)
            }
            logger.info("ModularEventBus APT processor Done");
            return true
        }
        logger.info("ModularEventBus APT processor Done with no work.");
        return false
    }

    /**
     * 2. Find and parse information of elements annotated with @EventGroup
     */
    private fun collectAnnotationMetas(groupElements: Set<Element>?): List<EventGroupMeta> {
        if (groupElements.isNullOrEmpty()) {
            // Nothing found.
            return emptyList()
        }
        logger.info(">>> Found event groups, size is " + groupElements.size + " <<<")

        val groupMetas = mutableListOf<EventGroupMeta>()

        for (groupElement: Element in groupElements) {
            // 2.1 Parse information of element annotated with @EventGroup.
            val groupMeta = (EventGroupMeta.parseMeta(groupElement, logger) ?: continue).apply {
                for (memberElement: Element in groupElement.enclosedElements) {
                    // 2.2 Parse information of enclosed methods.
                    addEventMeta(EventMeta.parseEventMeta(memberElement, logger, moduleName, autoClear) ?: continue)
                }
            }
            groupMetas.add(groupMeta)
        }

        logger.info(groupMetas.joinToString())
        return groupMetas
    }

    /**
     * 3. Generate EventsDefine file.
     */
    private fun generateJavaFiles(groupMetas: List<EventGroupMeta>) {
        // TypeElement of interface IEventGroup.
        val iEventGroup = elementUtils.getTypeElement(INTERFACE_IEVENT_GROUP)
        // TypeElement of interface IEvent.
        val iEvent = elementUtils.getTypeElement(INTERFACE_IEVENT)
        // TypeElement of class ModularEventBus.
        val modularEventBus = elementUtils.getTypeElement(FACADE_MODULAR_EVENT_BUS)
        // TypeMirror of type Void
        val voidTypeMirror = elementUtils.getTypeElement(VOID).asType()
        // TypeMirror of annotation @SuppressWarnings
        val suppressTypeMirror = elementUtils.getTypeElement(SUPPRESS_WARNINGS).asType()
        // TypeMirror of annotation @Deprecated
        val deprecatedTypeMirror = elementUtils.getTypeElement(DEPRECATED).asType()

        // Traversal all EventGroupMeta and generated file EventsDefineOf[ModulaName].
        for (groupMeta: EventGroupMeta in groupMetas) {
            if (groupMeta.isEmpty()) {
                return
            }

            // 3.1 Traversal all EventMeta and generated method [eventName].
            val methodSpecs = mutableListOf<MethodSpec>().apply {
                for (eventMeta in groupMeta.getAllEventMetas()) {
                    add(
                        MethodSpec.methodBuilder(eventMeta.element.simpleName.toString()).apply {
                            // Method prototype: public static IEvent<List<String>> eventName1() {
                            // 3.1.1 public
                            addModifiers(Modifier.PUBLIC)
                            // 3.1.2 static
                            addModifiers(Modifier.STATIC)
                            // 3.1.3 return
                            // Event data class type (void -> Void)
                            val returnType = if (eventMeta.returnType.kind == TypeKind.VOID)
                                voidTypeMirror
                            else
                                eventMeta.element.returnType
                            val returnTypeSpec: TypeName = ParameterizedTypeName.get(ClassName.get(iEvent), ClassName.get(returnType))
                            returns(returnTypeSpec)
                            // List<String>.class -> List.class
                            val dataTypeWithoutParameterType: TypeMirror = types.erasure(returnType)
                            // 3.1.4 @Deprecated
                            val deprecatedAnnotationSpec = if (groupMeta.isDeprecated) {
                                AnnotationSpec.builder(ClassName.get(deprecatedTypeMirror) as ClassName).build()
                            } else {
                                null
                            }
                            // 3.1.5 Method body: return ModularEventBus.createObservable("LiveDataBus","moduleName$$eventName1",List.class);
                            addStatement(
                                "return (\$T)(\$T.INSTANCE.createObservable(\$S, \$T.class,\$L,\$L))",
                                returnTypeSpec,
                                modularEventBus,
                                eventMeta.eventName,
                                dataTypeWithoutParameterType,
                                eventMeta.nullable,
                                eventMeta.autoClear
                            )
                            if (null != deprecatedAnnotationSpec) {
                                addAnnotation(deprecatedAnnotationSpec)
                            }
                        }.build()
                    )
                }
            }

            // 3.2 Private constructor.
            val constructorSpec = MethodSpec.constructorBuilder().addModifiers(Modifier.PRIVATE).build()

            // 3.3 @SuppressWarnings("unchecked")
            val uncheckAnnotationSpec: AnnotationSpec = AnnotationSpec.builder(ClassName.get(suppressTypeMirror) as ClassName)
                .addMember("value", "\$S", "unchecked")
                .build()

            // 3.4 @Deprecated
            val deprecatedAnnotationSpec = if (groupMeta.isDeprecated) {
                AnnotationSpec.builder(ClassName.get(deprecatedTypeMirror) as ClassName).build()
            } else {
                null
            }

            // 3.5 public class EventsDefineOfMyEventGroup implements IEventGroup.
            JavaFile.builder(
                PACKAGE_OF_GENERATE_FILE,
                TypeSpec.classBuilder(groupMeta.className).apply {
                    addJavadoc("Auto generate code, do not modify!!!\n")
                    addJavadoc("@see \$L", groupMeta.element.toString())
                    if (null != deprecatedAnnotationSpec) {
                        addAnnotation(deprecatedAnnotationSpec)
                    }
                    addAnnotation(uncheckAnnotationSpec)
                    addModifiers(Modifier.PUBLIC)
                    addSuperinterface(ClassName.get(iEventGroup))
                    addMethods(methodSpecs)
                    addMethod(constructorSpec)
                }.build()
            ).build().writeTo(mFiler)
        }
    }

    /**
     * 4. Generate Doc File.
     */
    private fun generateDocFiles(groupMetas: List<EventGroupMeta>) {
        if (!generateDoc || null == docWriter) {
            return
        }
        val groupDocList = LinkedList<EventGroupDoc>()
        for (groupMeta in groupMetas) {
            groupDocList.add(groupMeta.extractDocInfo())
        }

        docWriter?.append(JSON.toJSONString(groupDocList, SerializerFeature.PrettyFormat))
        docWriter?.flush()
        docWriter?.close()
    }
}