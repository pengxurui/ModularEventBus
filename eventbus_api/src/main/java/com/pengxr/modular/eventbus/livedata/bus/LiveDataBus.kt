package com.pengxr.modular.eventbus.livedata.bus

import com.pengxr.modular.eventbus.facade.template.IEvent

/**
 * Default EventBus base on Livedata.
 * <p>
 * Created by pengxr on 14/8/2022
 */
internal object LiveDataBus : NoObserverCallback {

    private val bus = HashMap<String, LiveEvent<*>>()

    /**
     * Create or get Event Observable for event [eventName].
     *
     * @param eventName Individual event name.
     * @param dataClazz Use to provide information to infer type variable T.
     * @param nullable Allow null data event or not.
     * @param autoClear AutoClear flag.
     */
    @Suppress("UNCHECKED_CAST")
    @Synchronized
    fun <T> with(eventName: String, dataClazz: Class<T>, autoClear: Boolean): IEvent<T> {
        if (!bus.containsKey(eventName)) {
            val liveData = UnPeekLiveData.Builder<T>()
                .setEventName(eventName)
                .setAllowNullValue(true)
                .setAutoClear(autoClear)
                .setNoObserverCallback(if (autoClear) this else null)
                .create()
            bus[eventName] = LiveEvent(eventName, liveData)
        }
        return bus[eventName] as LiveEvent<T>
    }

    /**
     * Remove event sent, the associated subscription will also be removed.
     */
    fun removeEvent(eventName: String) {
        bus.remove(eventName)
    }

    override fun onNoObserverAfterRemoved(event: ProtectedUnPeekLiveData<*>) {
        bus.remove(event.eventName)
    }
}