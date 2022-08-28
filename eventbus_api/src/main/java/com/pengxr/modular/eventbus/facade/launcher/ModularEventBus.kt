package com.pengxr.modular.eventbus.facade.launcher

import com.pengxr.modular.eventbus.facade.exception.IllegalEventBusFactoryException
import com.pengxr.modular.eventbus.facade.factory.IEventFactory
import com.pengxr.modular.eventbus.facade.template.BaseEvent
import com.pengxr.modular.eventbus.livedata.factory.LiveDataBusEventFactory
/**
 * __   __  _____               ____    _____    ______   _   _    _____
 * \ \ / / |_   _|     /\      / __ \  |  __ \  |  ____| | \ | |  / ____|
 *  \ V /    | |      /  \    | |  | | | |__) | | |__    |  \| | | |  __
 *   > <     | |     / /\ \   | |  | | |  ___/  |  __|   | . ` | | | |_ |
 *  / . \   _| |_   / ____ \  | |__| | | |      | |____  | |\  | | |__| |
 * /_/ \_\ |_____| /_/    \_\  \____/  |_|      |______| |_| \_|  \_____|
 *
 * ModularEventBus facade.
 * <p>
 * Created by pengxr on 13/8/2022
 */
object ModularEventBus {

    private var isDebug = false

    /**
     * Throw NullEventException while posting notnull event, always throw on debug type.
     */
    private var throwNullEventException = false

    /**
     * Global EventListener
     */
    var eventListener: IEventListener? = null
        private set

    /**
     * Default eventbus type.
     */
    private var defaultEventBusType = LiveDataBusEventFactory.NAME

    /**
     * EventBus factory registered.
     */
    private val eventBusFactory = HashMap<String, IEventFactory>()

    init {
        // Default EventBus
        registerEventFactory(LiveDataBusEventFactory(), true)
    }

    /**
     * Register a new eventBus factory.
     */
    private fun registerEventFactory(factory: IEventFactory, isDefault: Boolean = false): ModularEventBus {
        val oldFactory = eventBusFactory[factory.eventBusType()]
        if (null != oldFactory) {
            throw IllegalEventBusFactoryException("Duplicate eventbus factory type between ${oldFactory.javaClass.simpleName} and ${factory.javaClass.simpleName}")
        }
        eventBusFactory[factory.eventBusType()] = factory
        // Update default eventBus type.
        if (isDefault) {
            defaultEventBusType = factory.eventBusType()
        }
        return this
    }

    fun debug(isDebug: Boolean): ModularEventBus {
        this.isDebug = isDebug
        return this
    }

    fun throwNullEventException(isThrow: Boolean): ModularEventBus {
        this.throwNullEventException = isThrow
        return this
    }

    fun setEventListener(eventListener: IEventListener): ModularEventBus {
        this.eventListener = eventListener
        return this
    }

    internal fun shouldThrowNullEvent(): Boolean {
        return isDebug || throwNullEventException
    }

    internal fun isDebug(): Boolean {
        return isDebug
    }

    /**
     * Create event with eventName "[module]$$[eventName]"
     */
    fun createObservable(
        module: String,
        eventName: String,
        dataClazz: Class<*>,
        nullable: Boolean,
        autoClear: Boolean
    ): BaseEvent<*> =
        createObservable("${module}\$\$${eventName}", dataClazz, nullable, autoClear)

    /**
     * Create event with eventName "[fullEventName]"
     */
    fun createObservable(fullEventName: String, dataClazz: Class<*>, nullable: Boolean, autoClear: Boolean): BaseEvent<*> {
        // EventBus Type, use defaultEventBusType if missing.
        //val realBusType = busType.ifEmpty { defaultEventBusType }
        val realBusType = defaultEventBusType
        val iEventFactory = eventBusFactory[realBusType] ?: throw IllegalEventBusFactoryException("Miss eventBus factory type $realBusType")
        return iEventFactory.createEvent(fullEventName, dataClazz, nullable, autoClear)
    }
}