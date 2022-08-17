package com.pengxr.sampleorderlib

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pengxr.ktx.delegate.viewBinding
import com.pengxr.modular.eventbus.generated.events.EventDefineOfOrderEvents
import com.pengxr.sampleorderlib.databinding.ActivityOrderBinding
import com.pengxr.sampleorderlib.events.OrderInfo

class OrderActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityOrderBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // OrderLib events.
        EventDefineOfOrderEvents.commit().observeSticky(this) { value: OrderInfo? ->
            binding.tvStatusOrderSticky.text = "Order Status Sticky: ${value?.status}"
        }
    }

    fun onClickCommit(view: View) {
        Toast.makeText(this, "Commit.", Toast.LENGTH_SHORT).show()
        EventDefineOfOrderEvents.commit().post(OrderInfo("COMMITTED", "1000"))
    }

    fun onClickPay(view: View) {
        Toast.makeText(this, "Pay.", Toast.LENGTH_SHORT).show()
        EventDefineOfOrderEvents.pay().post(OrderInfo("PAYED", "1000"))
    }
}