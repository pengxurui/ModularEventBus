package com.pengxr.modular.eventbus.livedata.bus;

import androidx.annotation.NonNull;

/**
 * No Observer callback from Livedata, LivedataBus uses it remove LiveData.
 * <p>
 * Created by pengxr on 16/8/2022
 */
public interface NoObserverCallback {

    /**
     * Called if there is no observer related with the Livedata after removeObserver.
     */
    void onNoObserverAfterRemoved(@NonNull ProtectedUnPeekLiveData<?> event);
}
