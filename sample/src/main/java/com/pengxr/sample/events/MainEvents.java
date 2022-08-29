package com.pengxr.sample.events;

/**
 * Created by pengxr on 15/8/2022
 */

import com.pengxr.modular.eventbus.facade.annotation.EventGroup;

import androidx.annotation.NonNull;

@EventGroup
public interface MainEvents {

    @NonNull
    String nonNullEventInJava();

    void voidEventInJava1();

    Void voidEventInJava2();


}
