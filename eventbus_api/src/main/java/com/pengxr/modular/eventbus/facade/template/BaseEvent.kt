package com.pengxr.modular.eventbus.facade.template

/**
 * Base event class.
 * <p>
 * Created by pengxr on 15/8/2022
 */
abstract class BaseEvent<T>(

    /**
     * Individual eventName with format "[moduleName\$\$eventName]"
     */
    val eventName: String,

    /**
     * Event data type defined by the event method return type.
     */
    val dataClazz: Class<T>,

    /**
     * AutoClear flag.
     */
    val nullable: Boolean,

    /**
     * Allow null data event or not.
     */
    val autoClear: Boolean
) : IEvent<T>