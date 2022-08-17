package com.pengxr.modular.eventbus.livedata.factory

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.pengxr.modular.eventbus.facade.template.BaseEvent
import com.pengxr.modular.eventbus.facade.template.IEvent
import com.pengxr.modular.eventbus.livedata.bus.LiveDataBus

/**
 * Event observable base on Livedata.
 * <p>
 * Created by pengxr on 13/8/2022
 */
internal class LiveDataBusEvent<T>(eventName: String, dataClazz: Class<T>, nullable: Boolean, autoClear: Boolean) :
    BaseEvent<T>(eventName, dataClazz, nullable, autoClear) {

    override fun post(value: T?): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).post(value)
        return this
    }

    override fun postDelay(value: T?, delay: Long): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).postDelay(value, delay)
        return this
    }

    override fun postDelay(value: T?, delay: Long, producer: LifecycleOwner): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).postDelay(value, delay, producer)
        return this
    }

    override fun postOrderly(value: T?): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).postOrderly(value)
        return this
    }

    override fun observe(consumer: LifecycleOwner, observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).observe(consumer, observer)
        return this
    }

    override fun observeSticky(consumer: LifecycleOwner, observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).observeSticky(consumer, observer)
        return this
    }

    override fun observeForever(observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).observeForever(observer)
        return this
    }

    override fun observeStickyForever(observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).observeStickyForever(observer)
        return this
    }

    override fun removeObserver(observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, nullable, autoClear).removeObserver(observer)
        return this
    }

    override fun removeStickyEvent(): IEvent<T> {
        // Remove from LiveDataBus directly.
        LiveDataBus.removeStickyEvent(eventName)
        return this
    }
}