package com.pengxr.sample.events

import com.pengxr.modular.eventbus.facade.annotation.EventGroup

/**
 * Created by pengxr on 11/8/2022
 */
@EventGroup("sample")
interface BaseMainEvents {

    fun event1(): String?

    fun event2(): String

    fun event3(): Any

    fun event4(): List<String>
}