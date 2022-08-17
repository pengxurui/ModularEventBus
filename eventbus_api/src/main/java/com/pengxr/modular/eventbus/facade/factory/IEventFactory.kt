package com.pengxr.modular.eventbus.facade.factory

import com.pengxr.modular.eventbus.facade.template.BaseEvent

/**
 * Custom eventBus factory.
 * <p>
 * Created by pengxr on 13/8/2022
 */
interface IEventFactory {

    /**
     * Individual eventBus type name.
     */
    fun eventBusType(): String

    /**
     * Create event observable instance for eventName.
     *
     * @param eventName Individual event name.
     * @param dataClazz Use to provide information to infer type variable T.
     * @param nullable Allow null data event or not.
     * @param autoClear AutoClear flag.
     */
    fun <T> createEvent(eventName: String, dataClazz: Class<T>, nullable: Boolean, autoClear: Boolean): BaseEvent<T>
}