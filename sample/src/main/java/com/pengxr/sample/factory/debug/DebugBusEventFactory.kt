package com.pengxr.sample.factory.debug

import com.pengxr.modular.eventbus.facade.factory.IEventFactory
import com.pengxr.modular.eventbus.facade.template.BaseEvent

/**
 * Fake EventBus for debug.
 * <p>
 * Created by pengxr on 13/8/2022
 */
class DebugBusEventFactory : IEventFactory {

    override fun eventBusType() = "DebugBus"

    override fun <T> createEvent(eventName: String, dataClazz: Class<T>, nullable: Boolean, autoClear: Boolean): BaseEvent<T> =
        DebugBusEvent(eventName, dataClazz, nullable, autoClear)
}