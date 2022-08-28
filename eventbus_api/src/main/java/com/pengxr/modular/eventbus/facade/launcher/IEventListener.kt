package com.pengxr.modular.eventbus.facade.launcher

import com.pengxr.modular.eventbus.facade.template.BaseEvent

/**
 * Global eventListener.
 * <p>
 * Created by pengxr on 28/8/2022
 */
interface IEventListener {

    fun <T> onEventPost(eventName: String, event: BaseEvent<T>, data: T?)

}