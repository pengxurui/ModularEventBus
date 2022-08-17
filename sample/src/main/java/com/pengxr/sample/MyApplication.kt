package com.pengxr.sample

import android.app.Application
import com.pengxr.modular.eventbus.facade.launcher.ModularEventBus

/**
 * Created by pengxr on 14/8/2022
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ModularEventBus.debug(true)
            .throwNullEventException(true)

//        ModularEventBus.registerEventFactory(DebugBusEventFactory(), true)
    }
}