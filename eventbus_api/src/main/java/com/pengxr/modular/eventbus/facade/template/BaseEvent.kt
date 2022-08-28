package com.pengxr.modular.eventbus.facade.template

import androidx.lifecycle.LifecycleOwner
import com.pengxr.modular.eventbus.facade.exception.NullEventException
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

    /**
     * Check whether the data meet the event.
     *
     * @return true:available
     */
    private fun checkEventData(value: T?): Boolean {
        if (null != value || nullable) {
            return true
        }
        if (ModularEventBus.shouldThrowNullEvent()) {
            throw NullEventException("Post nonnull event $eventName with a null value.")
        }
        return false
    }

    override fun post(value: T?): IEvent<T> {
        if (checkEventData(value)) {
            ModularEventBus.eventListener?.onEventPost(eventName, this, value)
            doPost(value)
        }
        return this
    }

    override fun postDelay(value: T?, delay: Long): IEvent<T> {
        if (checkEventData(value)) {
            ModularEventBus.eventListener?.onEventPost(eventName, this, value)
            doPostDelay(value, delay)
        }
        return this
    }

    override fun postDelay(value: T?, delay: Long, producer: LifecycleOwner): IEvent<T> {
        if (checkEventData(value)) {
            ModularEventBus.eventListener?.onEventPost(eventName, this, value)
            doPostDelay(value, delay, producer)
        }
        return this
    }

    override fun postOrderly(value: T?): IEvent<T> {
        if (checkEventData(value)) {
            ModularEventBus.eventListener?.onEventPost(eventName, this, value)
            doPostOrderly(value)
        }
        return this
    }

    protected abstract fun doPost(value: T?)

    protected abstract fun doPostDelay(value: T?, delay: Long)

    protected abstract fun doPostDelay(value: T?, delay: Long, producer: LifecycleOwner)

    protected abstract fun doPostOrderly(value: T?)
}