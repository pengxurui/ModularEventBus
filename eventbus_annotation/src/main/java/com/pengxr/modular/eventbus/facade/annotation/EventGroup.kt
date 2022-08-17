package com.pengxr.modular.eventbus.facade.annotation

/**
 * Annotation used to define a group of event.
 * <p>
 * Created by pengxr on 10/8/2022
 */
@kotlin.annotation.Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class EventGroup(

    /**
     * Define module name, use package name if empty.
     */
    val moduleName: String = "",

    /**
     * Define autoClear flag, use false if empty.
     */
    val autoClear: Boolean = false
)