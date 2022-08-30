package com.pengxr.modular.eventbus.compiler.model

import com.pengxr.modular.eventbus.compiler.exception.IllegalEventGroupException
import com.pengxr.modular.eventbus.compiler.utils.Logger
import com.pengxr.modular.eventbus.compiler.utils.TAG
import com.pengxr.modular.eventbus.facade.annotation.EventGroup
import com.pengxr.modular.eventbus.facade.annotation.Ignore
import java.util.*
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement

/**
 * It contains event group information, used for generate EventsDefine java file.
 * <p>
 * Created by pengxr on 12/8/2022
 */
class EventGroupMeta(

    /**
     * Interface annotated with @EventGroup.
     */
    var element: TypeElement,

    /**
     * Class name of the element.
     */
    var className: String,

    /**
     * Module name defined in @EventGroup, use package name if empty.
     */
    var moduleName: String,

    /**
     * AutoClear flag.
     */
    var autoClear: Boolean,

    /**
     * @Deprecated flag.
     */
    var isDeprecated: Boolean
) {

    companion object {

        /**
         * Parse information of interface annotated with @EventGroup.
         *
         * @return null if not a interface type, or miss @EventGroup.
         */
        fun parseMeta(element: Element, logger: Logger): EventGroupMeta? {
            if (null != element.getAnnotation(Ignore::class.java)) {
                return null
            }
            if (element !is TypeElement) {
                return null
            }
            if (!element.kind.isInterface) {
                if (element.kind.isClass) {
                    logger.warning("${TAG}Annotated @EventGroup on a class type [${element.simpleName}], expected a interface. Is that really what you want?")
                } else {
                    throw IllegalEventGroupException("${TAG}Annotated @EventGroup on element [${element.simpleName}], expected a interface.")
                }
            }
            if (element.interfaces.isNotEmpty()) {
                throw IllegalEventGroupException("${TAG}Inherited interface [${element.simpleName}] brings complexity, it is not allowed.")
            }
            val groupAnnotation = element.getAnnotation(EventGroup::class.java) ?: return null
            val fullClassName = "${element.qualifiedName}"
            val className = "EventDefineOf${element.simpleName}"
            val moduleName = groupAnnotation.moduleName.ifEmpty { fullClassName }
            val autoClear = groupAnnotation.autoClear
            val isDeprecated = null != element.getAnnotation(java.lang.Deprecated::class.java)
            return EventGroupMeta(
                element = element,
                className = className,
                moduleName = moduleName,
                autoClear = autoClear,
                isDeprecated = isDeprecated
            )
        }
    }

    /**
     * It contains event information enclosed.
     */
    private val eventMetas: MutableList<EventMeta> = mutableListOf()

    fun addEventMeta(eventMeta: EventMeta) {
        eventMetas.add(eventMeta)
    }

    fun removeEventMeta(eventMeta: EventMeta) {
        eventMetas.remove(eventMeta)
    }

    fun isEmpty() = eventMetas.isEmpty()

    fun getAllEventMetas(): List<EventMeta> = eventMetas

    fun extractDocInfo(): EventGroupDoc {
        return EventGroupDoc(
            group = className,
            isDeprecated = isDeprecated,
            events = LinkedList<EventDoc>().apply {
                eventMetas.forEach {
                    add(it.extractDocInfo())
                }
            },
        )
    }

    override fun toString(): String {
        return "EventGroupMeta{" +
                "element=" + element +
                ", className=" + className +
                ", moduleName=" + moduleName +
                ", autoClear=" + autoClear +
                ", isDeprecated=" + isDeprecated +
                ", eventMetas=" + eventMetas.joinToString() +
                '}'
    }
}