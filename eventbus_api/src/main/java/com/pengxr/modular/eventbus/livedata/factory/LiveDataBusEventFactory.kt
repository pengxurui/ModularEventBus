package com.pengxr.modular.eventbus.livedata.factory

import com.pengxr.modular.eventbus.facade.factory.IEventFactory
import com.pengxr.modular.eventbus.facade.template.BaseEvent

/**
 * Custom eventBus factory base on LiveDataBus.
 * <p>
 * Created by pengxr on 13/8/2022
 */
internal class LiveDataBusEventFactory : IEventFactory {

    companion object {
        const val NAME = "LiveDataBus"
    }

    /**
     * Individual eventBus type name.
     */
    override fun eventBusType() = NAME

    /**
     * Create event observable instance for eventName.
     *
     * @param eventName Individual event name.
     * @param dataClazz Use to provide information to infer type variable T.
     * @param nullable Allow null data event or not.
     * @param autoClear AutoClear flag.
     */
    override fun <T> createEvent(eventName: String, dataClazz: Class<T>, nullable: Boolean, autoClear: Boolean): BaseEvent<T> {
        return LiveDataBusEvent(eventName, dataClazz, nullable, autoClear)
    }
}