package com.pengxr.samblebaselib.events

import com.pengxr.modular.eventbus.facade.annotation.EventGroup
import com.pengxr.modular.eventbus.facade.annotation.Ignore

/**
 * Created by pengxr on 11/8/2022
 */
@EventGroup
interface BaseEvents {

    @Ignore
    fun event1(): String?

    fun event2(): String

    fun event3(): Any?

    fun event4(): List<String>?

    fun event5(): List<Set<Map<String, List<String>>>>?
}