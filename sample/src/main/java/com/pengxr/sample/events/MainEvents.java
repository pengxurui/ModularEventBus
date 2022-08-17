package com.pengxr.sample.events;

/**
 * <p>
 * Created by pengxr on 15/8/2022
 */

import com.pengxr.modular.eventbus.facade.annotation.Event;
import com.pengxr.modular.eventbus.facade.annotation.EventGroup;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;

@EventGroup(autoClear = true)
public interface MainEvents {

    @Event
    @NonNull
    String event1();

    @Event(autoClear = true)
    @NotNull
    String event2();

    String event3();
}
