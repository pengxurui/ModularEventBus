package com.pengxr.sampleloginlib

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pengxr.modular.eventbus.generated.events.EventDefineOfBaseEvents
import com.pengxr.modular.eventbus.generated.events.EventDefineOfLoginEvents
import com.pengxr.sampleloginlib.events.UserInfo


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onClickLogin(view: View) {
        Toast.makeText(this, "Login.", Toast.LENGTH_SHORT).show()
        EventDefineOfLoginEvents.login().post(UserInfo("XIAOPENG"))
    }

    fun onClickLogout(view: View) {
        Toast.makeText(this, "Logout.", Toast.LENGTH_SHORT).show()
        EventDefineOfLoginEvents.logout().post(null)
    }

    fun onClickBase(view: View) {
        Toast.makeText(this, "Generic Test.", Toast.LENGTH_SHORT).show()
        val map: Map<String, List<String>> = mapOf("XIAOPENG" to listOf("Android", "Android"))
        val set = setOf(map)
        val list = listOf(set)
        EventDefineOfBaseEvents.event5().post(list)
    }
}