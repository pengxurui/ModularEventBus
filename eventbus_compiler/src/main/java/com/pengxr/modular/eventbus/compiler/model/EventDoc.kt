package com.pengxr.modular.eventbus.compiler.model

import com.alibaba.fastjson.annotation.JSONField

/**
 * It contains event information, used for generate router map
 * <p>
 * Created by pengxr on 17/8/2022
 */
class EventDoc(
    @JSONField(ordinal = 1)
    val eventName: String,

    @JSONField(ordinal = 2)
    val dataType: String,

    @JSONField(ordinal = 3)
    val nullable: Boolean,

    @JSONField(ordinal = 4)
    val autoClear: Boolean,

    @JSONField(ordinal = 5)
    var isDeprecated: Boolean
)