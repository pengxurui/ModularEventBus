package com.pengxr.modular.eventbus.facade.annotation

/**
 * Annotation used to define a single event. You don't have to annotate method with this,
 * all method define in interface annotated with @EventGroup are regarded as event.
 * <p>
 * Created by pengxr on 16/8/2022
 */
annotation class Event(

    /**
     * Define autoClear flag, use false if empty.
     */
    val autoClear: Boolean = false
)
