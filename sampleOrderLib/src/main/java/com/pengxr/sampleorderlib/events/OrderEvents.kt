package com.pengxr.sampleorderlib.events

import com.pengxr.modular.eventbus.facade.annotation.EventGroup

/**
 * Created by pengxr on 11/8/2022
 */
@EventGroup
interface OrderEvents {

//    @Event(autoClear = true)
    fun commit(): OrderInfo

    fun pay(): OrderInfo
}