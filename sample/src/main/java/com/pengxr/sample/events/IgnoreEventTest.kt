package com.pengxr.sample.events

import com.pengxr.modular.eventbus.facade.annotation.EventGroup
import com.pengxr.modular.eventbus.facade.annotation.Ignore

/**
 * Test @Ignore annotation.
 * <p>
 * Created by pengxr on 28/8/2022
 */
@Ignore
@EventGroup
interface IgnoreEventTest {

    @Ignore
    fun ignoredMethod()

    fun method()
}