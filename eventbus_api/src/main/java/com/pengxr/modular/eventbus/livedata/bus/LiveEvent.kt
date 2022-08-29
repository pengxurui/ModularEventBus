package com.pengxr.modular.eventbus.livedata.bus

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.pengxr.modular.eventbus.facade.template.IEvent
import com.pengxr.modular.eventbus.utils.isMainThread

/**
 * LiveData Wrapper used to support IEvent.
 * <p>
 * Created by pengxr on 17/8/2022
 */
internal class LiveEvent<T>(private val liveData: UnPeekLiveData<T?>) : IEvent<T> {

    private val mainHandler = Handler(Looper.getMainLooper())

    @SuppressLint("WrongThread")
    override fun post(value: T?) {
        if (isMainThread()) {
            liveData.value = value
        } else {
            mainHandler.post { liveData.value = value }
        }
    }

    override fun postDelay(value: T?, delay: Long) {
        mainHandler.postDelayed({ liveData.value = value }, delay)
    }

    override fun postDelay(value: T?, delay: Long, producer: LifecycleOwner) {
        mainHandler.postDelayed({
            if (producer.lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                liveData.value = value
            }
        }, delay)
    }

    override fun postOrderly(value: T?) {
        mainHandler.post {
            liveData.value = value
        }
    }

    override fun observe(consumer: LifecycleOwner, observer: Observer<T?>) {
        if (isMainThread()) {
            liveData.observe(consumer, observer)
        } else {
            mainHandler.post { liveData.observe(consumer, observer) }
        }
    }

    override fun observeSticky(consumer: LifecycleOwner, observer: Observer<T?>) {
        if (isMainThread()) {
            liveData.observeSticky(consumer, observer)
        } else {
            mainHandler.post { liveData.observeSticky(consumer, observer) }
        }
    }

    override fun observeForever(observer: Observer<T?>) {
        if (isMainThread()) {
            liveData.observeForever(observer)
        } else {
            mainHandler.post { liveData.observeForever(observer) }
        }
    }

    override fun observeStickyForever(observer: Observer<T?>) {
        if (isMainThread()) {
            liveData.observeStickyForever(observer)
        } else {
            mainHandler.post { liveData.observeStickyForever(observer) }
        }
    }

    override fun removeObserver(observer: Observer<T?>) {
        if (isMainThread()) {
            liveData.removeObserver(observer)
        } else {
            mainHandler.post { liveData.removeObserver(observer) }
        }
    }

    override fun removeStickyEvent() {
        // Do nothing.
    }
}