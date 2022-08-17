package com.pengxr.sample.factory.debug

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.pengxr.modular.eventbus.facade.template.BaseEvent
import com.pengxr.modular.eventbus.facade.template.IEvent
import com.pengxr.sample.utils.TAG

/**
 * Fake EventBus for debug.
 * <p>
 * Created by pengxr on 13/8/2022
 */
class DebugBusEvent<T>(eventName: String, dataClazz: Class<T>, nullable: Boolean, autoClear: Boolean) :
    BaseEvent<T>(eventName, dataClazz, nullable, autoClear) {

    override fun post(value: T?): IEvent<T> {
        Log.d(TAG, "post event = $eventName, value = $value")
        return this
    }

    override fun postDelay(value: T?, delay: Long): IEvent<T> {
        Log.d(TAG, "postOrderly event = $eventName, value = $value, delay = $delay")
        return this
    }

    override fun postDelay(value: T?, delay: Long, producer: LifecycleOwner): IEvent<T> {
        Log.d(TAG, "postOrderly event = $eventName, value = $value, delay = $delay")
        return this
    }

    override fun postOrderly(value: T?): IEvent<T> {
        Log.d(TAG, "postOrderly event = $eventName, value = $value")
        return this
    }

    override fun observe(consumer: LifecycleOwner, observer: Observer<T?>): IEvent<T> {
        Log.d(TAG, "observe: $observer")
        return this
    }

    override fun observeSticky(consumer: LifecycleOwner, observer: Observer<T?>): IEvent<T> {
        Log.d(TAG, "observeSticky: $observer")
        return this
    }

    override fun observeForever(observer: Observer<T?>): IEvent<T> {
        Log.d(TAG, "observeForever: $observer")
        return this
    }

    override fun observeStickyForever(observer: Observer<T?>): IEvent<T> {
        Log.d(TAG, "observeStickyForever: $observer")
        return this
    }

    override fun removeObserver(observer: Observer<T?>): IEvent<T> {
        Log.d(TAG, "removeObserver: $observer")
        return this
    }

    override fun removeStickyEvent(): IEvent<T> {
        Log.d(TAG, "removeStickyEvent")
        return this
    }
}