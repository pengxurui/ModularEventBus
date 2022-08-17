package com.pengxr.sample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pengxr.ktx.delegate.viewBinding
import com.pengxr.modular.eventbus.generated.events.EventDefineOfBaseEvents
import com.pengxr.modular.eventbus.generated.events.EventDefineOfLoginEvents
import com.pengxr.modular.eventbus.generated.events.EventDefineOfOrderEvents
import com.pengxr.sample.databinding.ActivityMainBinding
import com.pengxr.sampleloginlib.LoginActivity
import com.pengxr.sampleloginlib.events.UserInfo
import com.pengxr.sampleorderlib.OrderActivity
import com.pengxr.sampleorderlib.events.OrderInfo

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // LoginLib events.
        EventDefineOfLoginEvents.login().observe(this) { value: UserInfo? ->
            binding.tvStatusLogin.text = "LoginLib Status: ${value?.userName}"
        }
        EventDefineOfLoginEvents.logout().observe(this) { _: Void? ->
            binding.tvStatusLogin.text = "LoginLib Status:"
        }

        // OrderLib events.
        EventDefineOfOrderEvents.commit().observeForever { value: OrderInfo? ->
            binding.tvStatusOrder.text = "OrderLib Status: ${value?.status}"
        }
        EventDefineOfOrderEvents.pay().observe(this) { value: OrderInfo? ->
            binding.tvStatusOrder.text = "OrderLib Status: ${value?.status}"
        }

        // BaseLib events.
        EventDefineOfBaseEvents.event5().observeStickyForever { value: List<Set<Map<String, List<String>>>>? ->
            binding.tvStatusBase.text = "BaseLib Status：${value?.joinToString()}"
        }
    }

    fun onClickLoginPage(view: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun onClickOrderPage(view: View) {
        startActivity(Intent(this, OrderActivity::class.java))
    }
}