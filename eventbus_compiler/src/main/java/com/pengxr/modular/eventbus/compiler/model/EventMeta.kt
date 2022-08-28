package com.pengxr.modular.eventbus.compiler.model

import com.pengxr.modular.eventbus.compiler.utils.Logger
import com.pengxr.modular.eventbus.compiler.utils.SEPARATOR
import com.pengxr.modular.eventbus.compiler.utils.isAnnotatedWithNullable
import com.pengxr.modular.eventbus.facade.annotation.Event
import com.pengxr.modular.eventbus.facade.annotation.Ignore
import javax.lang.model.element.Element
import javax.lang.model.element.ElementKind
import javax.lang.model.element.ExecutableElement
import javax.lang.model.type.TypeKind
import javax.lang.model.type.TypeMirror

/**
 * It contains event information, used for generate EventsDefine java file.
 * <p>
 * Created by pengxr on 12/8/2022
 */
class EventMeta(

    /**
     * Method program element
     */
    var element: ExecutableElement,

    /**
     * Name of the method.
     */
    var eventName: String,

    /**
     * Return type
     */
    var returnType: TypeMirror,

    /**
     * Allow null data event or not.
     */
    var nullable: Boolean,

    /**
     * AutoClear flag.
     */
    val autoClear: Boolean,

    /**
     * @Deprecated flag.
     */
    var isDeprecated: Boolean
) {

    companion object {

        /**
         * Parse information of method program element.
         *
         * @param element Element enclosed in interface annotated with @EventGroup.
         * @param autoClear AutoClear Flag defined in @EventGroup.
         *
         * @return null if not a method program element, or annotated with @Ignore.
         */
        fun parseEventMeta(element: Element, moduleNameInEventGroup: String, autoClearInEventGroup: Boolean): EventMeta? {
            if (element !is ExecutableElement) {
                return null
            }
            if (null != element.getAnnotation(Ignore::class.java)) {
                return null
            }
            val annotation = element.getAnnotation(Event::class.java)
            val eventName = "$moduleNameInEventGroup$SEPARATOR${element.simpleName}"
            val returnType = element.returnType
            // If return type is void, treat it as a nullable event.
            val nullable = returnType.kind == TypeKind.VOID || element.isAnnotatedWithNullable()
            val autoClearInEvent = annotation?.autoClear ?: autoClearInEventGroup
            val isDeprecated = null != element.getAnnotation(java.lang.Deprecated::class.java)
            return EventMeta(
                element = element,
                eventName = eventName,
                returnType = returnType,
                nullable = nullable,
                autoClear = autoClearInEvent,
                isDeprecated = isDeprecated,
            )
        }
    }

    fun extractDocInfo(): EventDoc {
        return EventDoc(
            eventName = eventName,
            dataType = returnType.toString(),
            nullable = nullable,
            autoClear = autoClear,
            isDeprecated = isDeprecated,
        )
    }

    override fun toString(): String {
        return "EventMeta{" +
                "element=" + element +
                ", eventName=" + eventName +
                ", returnType=" + returnType +
                ", autoClear=" + autoClear +
                ", nullable=" + nullable +
                ", isDeprecated=" + isDeprecated +
                '}'
    }
}