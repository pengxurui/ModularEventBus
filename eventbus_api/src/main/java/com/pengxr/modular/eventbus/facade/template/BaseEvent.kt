package com.pengxr.modular.eventbus.facade.template

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import com.pengxr.modular.eventbus.facade.launcher.ModularEventBus

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
) : IEvent<T> {

    @CallSuper
    override fun post(value: T?): IEvent<T> {
        ModularEventBus.eventListener?.onEventPost(eventName, this, value)
        return this
    }

    @CallSuper
    override fun postDelay(value: T?, delay: Long): IEvent<T> {
        ModularEventBus.eventListener?.onEventPost(eventName, this, value)
        return this
    }

    @CallSuper
    override fun postDelay(value: T?, delay: Long, producer: LifecycleOwner): IEvent<T> {
        ModularEventBus.eventListener?.onEventPost(eventName, this, value)
        return this
    }

    @CallSuper
    override fun postOrderly(value: T?): IEvent<T> {
        ModularEventBus.eventListener?.onEventPost(eventName, this, value)
        return this
    }
}