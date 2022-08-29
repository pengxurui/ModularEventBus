package com.pengxr.sample.events

import com.pengxr.modular.eventbus.facade.annotation.Event
import com.pengxr.modular.eventbus.facade.annotation.EventGroup

/**
 * Created by pengxr on 28/8/2022
 */
@EventGroup
interface MainEventsKt {

    fun nonNullEventInKotlin(): String

    fun voidEventInKotlin1()
    fun voidEventInKotlin2(): Unit
    fun voidEventInKotlin3(): Unit?

    @Deprecated("Don't use it.")
    fun deprecatedEvent()

    fun genericEvent(): List<String>

    @Event(autoClear = true)
    fun autoClearEvent(): String

    fun lifecycleObserverEvent(): String

    fun delayEvent(): String
}