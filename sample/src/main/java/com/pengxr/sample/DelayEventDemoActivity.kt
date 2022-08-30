package com.pengxr.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pengxr.modular.eventbus.generated.events.EventDefineOfMainEventsKt
import com.pengxr.sample.utils.toast

class DelayEventDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delay_event_demo)

        EventDefineOfMainEventsKt.delayEvent().observe(this) {
            toast("Receive delayed event from observer, event=$it.")
        }
        EventDefineOfMainEventsKt.delayEvent().observeForever {
            toast("Receive delayed event from forever observer, event=$it.")
        }
    }

    // Click to send an event with a delay of 5s, and finish activity to test.
    fun onClickDelayEvent(view: View) {
        // Post event with a delay of 5s.
        EventDefineOfMainEventsKt.delayEvent().postDelay("XIAO PENG 1", 5000)
        // Post event with a delay of 5s, only if the producer is active.
        EventDefineOfMainEventsKt.delayEvent().postDelay("XIAO PENG 2", 5000, this)
    }
}