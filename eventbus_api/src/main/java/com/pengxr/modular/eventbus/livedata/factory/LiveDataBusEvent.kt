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

    override fun doPost(value: T?) {
        LiveDataBus.with(eventName, dataClazz, autoClear).post(value)
    }

    override fun doPostDelay(value: T?, delay: Long) {
        LiveDataBus.with(eventName, dataClazz, autoClear).postDelay(value, delay)
    }

    override fun doPostDelay(value: T?, delay: Long, producer: LifecycleOwner) {
        LiveDataBus.with(eventName, dataClazz, autoClear).postDelay(value, delay, producer)
    }

    override fun doPostOrderly(value: T?) {
        LiveDataBus.with(eventName, dataClazz, autoClear).postOrderly(value)
    }

    override fun observe(consumer: LifecycleOwner, observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, autoClear).observe(consumer, observer)
        return this
    }

    override fun observeSticky(consumer: LifecycleOwner, observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, autoClear).observeSticky(consumer, observer)
        return this
    }

    override fun observeForever(observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, autoClear).observeForever(observer)
        return this
    }

    override fun observeStickyForever(observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, autoClear).observeStickyForever(observer)
        return this
    }

    override fun removeObserver(observer: Observer<T?>): IEvent<T> {
        LiveDataBus.with(eventName, dataClazz, autoClear).removeObserver(observer)
        return this
    }

    override fun removeStickyEvent(): IEvent<T> {
        // Remove from LiveDataBus directly.
        LiveDataBus.removeStickyEvent(eventName)
        return this
    }
}