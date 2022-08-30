package com.pengxr.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pengxr.modular.eventbus.generated.events.EventDefineOfMainEventsKt
import com.pengxr.sample.utils.toast

/**
 * Created by pengxr on 29/8/2022
 */
class StickyEventDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sticky_event_demo)

        EventDefineOfMainEventsKt.stickyEvent().observeSticky(this) {
            toast("Receive event from observer, event=$it.")
        }
        EventDefineOfMainEventsKt.stickyEvent().observeStickyForever {
            toast("Receive event from forever observer, event=$it.")
        }
    }

    // Click to send an event, and finish activity to test sticky observer.
    fun onClickStickyEvent(view: View) {
        EventDefineOfMainEventsKt.stickyEvent().post("XIAO PENG")
    }

    fun onClickRemoveStickyEvent(view: View) {
        EventDefineOfMainEventsKt.stickyEvent().removeStickyEvent()
    }
}