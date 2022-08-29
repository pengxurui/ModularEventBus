package com.pengxr.sampleloginlib.events

import com.pengxr.modular.eventbus.facade.annotation.Event
import com.pengxr.modular.eventbus.facade.annotation.EventGroup
import com.pengxr.modular.eventbus.facade.annotation.Ignore
import com.pengxr.sampleloginlib.entity.UserInfo

/**
 * Created by pengxr on 11/8/2022
 */
@EventGroup
interface LoginEvents {

    @Event(autoClear = true)
    fun login(): UserInfo

    @Ignore
    fun logout()

}