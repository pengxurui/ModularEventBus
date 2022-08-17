package com.pengxr.sampleloginlib.events

import com.pengxr.modular.eventbus.facade.annotation.EventGroup

/**
 * Created by pengxr on 11/8/2022
 */
@EventGroup
interface LoginEvents {

    fun login(): UserInfo?

    fun logout()

    fun event8()
}