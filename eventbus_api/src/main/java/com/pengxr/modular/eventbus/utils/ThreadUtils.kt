package com.pengxr.modular.eventbus.utils

import android.os.Looper

/**
 * Thread helper
 * <p>
 * Created by pengxr on 16/8/2022
 */
fun isMainThread() = Looper.myLooper() == Looper.getMainLooper()