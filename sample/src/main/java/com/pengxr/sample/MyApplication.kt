package com.pengxr.sample

import android.app.Application
import android.util.Log
import com.pengxr.modular.eventbus.facade.launcher.IEventListener
import com.pengxr.modular.eventbus.facade.launcher.ModularEventBus
import com.pengxr.modular.eventbus.facade.template.BaseEvent
import com.pengxr.sample.utils.TAG

/**
 * Created by pengxr on 14/8/2022
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ModularEventBus.debug(true)
            .throwNullEventException(true)
            .setEventListener(object : IEventListener {
                override fun <T> onEventPost(eventName: String, event: BaseEvent<T>, data: T?) {
                    Log.i(TAG, "onEventPost: $eventName, event = $event, data = $data")
                }
            })
    }
}