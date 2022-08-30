package com.pengxr.modular.eventbus.facade.template

import androidx.annotation.AnyThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

/**
 * Base event interface, it contains post methods for producer and observe methods for consumer.
 * <p>
 * Created by pengxr on 15/8/2022
 */
interface IEvent<T> {

    /**
     * Send a event now. If this method is called from the background thread, it will post a runnable to the
     * main thread before sending event.
     *
     * @param value Event data.
     */
    @AnyThread
    fun post(value: T?)

    /**
     * Send a delay event. If this method is called from the background thread, it will post a runnable to the
     * main thread before sending event.
     *
     * @param value Event data.
     * @param delay Delay time.
     */
    @AnyThread
    fun postDelay(value: T?, delay: Long)

    /**
     * Send a delay event. If this method is called from the background thread, it will post a runnable to the
     * main thread before sending event. If the producer's lifecycle is not active after time delayed, it will
     * prevents the event from being sent.
     *
     * @param value Event data.
     * @param delay Delay time.
     * @param producer LifecycleOwner of the event producer.
     */
    @AnyThread
    fun postDelay(value: T?, delay: Long, producer: LifecycleOwner)

    /**
     * Send a event now. It ensures the receiving order is consistent with the sending order.
     *
     * @param value Event data.
     */
    @AnyThread
    fun postOrderly(value: T?)

    /**
     * Register a new observer, and associated with the lifecycle of owner.
     *
     * @param consumer LifecycleOwner of the event consumer.
     * @param observer Event observer.
     *
     * @param consumer LifecycleOwner of the event consumer.
     * @param observer Event observer.
     */
    @AnyThread
    fun observe(consumer: LifecycleOwner, observer: Observer<T?>)

    /**
     * Register a new observer, and associated with the lifecycle of owner. It will received event
     * sent before.
     *
     * @param consumer LifecycleOwner of the event consumer.
     * @param observer Event observer.
     */
    @AnyThread
    fun observeSticky(consumer: LifecycleOwner, observer: Observer<T?>)

    /**
     * Register a new observer forever, it's expected to unregister after.
     *
     * @param observer Event observer.
     */
    @AnyThread
    fun observeForever(observer: Observer<T?>)

    /**
     * Register a new observer forever, it's expected to unregister after. It will received event
     * sent before.
     *
     * @param observer Event observer.
     */
    @AnyThread
    fun observeStickyForever(observer: Observer<T?>)

    /**
     * Unregister a observer.
     * @param observer Event observer.
     */
    @AnyThread
    fun removeObserver(observer: Observer<T?>)

    /**
     * Remove event sent, the associated subscription will also be removed.
     */
    @AnyThread
    fun removeEvent()
}