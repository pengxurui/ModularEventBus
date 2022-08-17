package com.pengxr.modular.eventbus.compiler.model

import com.alibaba.fastjson.annotation.JSONField

/**
 * It contains event group information, used for generate router map.
 * <p>
 * Created by pengxr on 17/8/2022
 */
class EventGroupDoc(
    @JSONField(ordinal = 1)
    val group: String,

    @JSONField(ordinal = 2)
    val events: List<EventDoc>
)