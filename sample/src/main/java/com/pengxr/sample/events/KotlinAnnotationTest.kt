package com.pengxr.sample.events

import com.pengxr.modular.eventbus.facade.annotation.EventGroup

/**
 * Define events using Kotlin.
 * <p>
 * Created by pengxr on 28/8/2022
 */
@EventGroup
interface KotlinAnnotationTest {

    fun kotlinMethod(): String
}