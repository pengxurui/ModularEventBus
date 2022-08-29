package com.pengxr.modular.eventbus.livedata.bus

/**
 * No Observer callback from Livedata, LivedataBus uses it remove LiveData.
 * Created by pengxr on 16/8/2022
 */
internal interface NoObserverCallback {
    /**
     * Called if there is no observer related with the Livedata after removeObserver.
     */
    fun onNoObserverAfterRemoved(event: ProtectedUnPeekLiveData<*>)
}