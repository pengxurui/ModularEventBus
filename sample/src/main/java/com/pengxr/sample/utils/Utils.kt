package com.pengxr.sample.utils

import android.content.Context
import android.widget.Toast

/**
 * <p>
 * Created by pengxr on 29/8/2022
 */
fun Context.toast(str: String) {
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
}