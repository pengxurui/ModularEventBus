package com.pengxr.sample.events

import com.pengxr.modular.eventbus.facade.annotation.EventGroup

/**
 * Test @Deprecated annotation.
 * <p>
 * Created by pengxr on 28/8/2022
 */
@Deprecated("Don't use it.")
@EventGroup
interface DeprecatedEventTest {

    @Deprecated("Don't use it.")
    fun deprecatedMethod()
}