package com.pengxr.modular.eventbus.facade.annotation

/**
 * Annotation used to define a single event. You don't have to annotate method with this,
 * all method define in interface annotated with @EventGroup are regarded as event.
 * <p>
 * Tips: Use AnnotationRetention.BINARY to make it not be removed when the code is minified at build time.
 * <p>
 * Created by pengxr on 16/8/2022
 */
@kotlin.annotation.Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class Event(

    /**
     * Define autoClear flag, use false if empty.
     */
    val autoClear: Boolean = false
)
