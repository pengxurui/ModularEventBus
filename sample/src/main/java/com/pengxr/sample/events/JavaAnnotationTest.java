package com.pengxr.sample.events;

import com.pengxr.modular.eventbus.facade.annotation.EventGroup;

/**
 * Define events using Java.
 * <p>
 * Created by pengxr on 28/8/2022
 */
@EventGroup
interface JavaAnnotationTest {

    String javaMethod();
}