package com.pengxr.sample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.pengxr.modular.eventbus.facade.exception.NullEventException
import com.pengxr.modular.eventbus.generated.events.EventDefineOfLoginEvents
import com.pengxr.modular.eventbus.generated.events.EventDefineOfMainEvents
import com.pengxr.modular.eventbus.generated.events.EventDefineOfMainEventsKt
import com.pengxr.sample.utils.TAG
import com.pengxr.sample.utils.toast
import com.pengxr.sampleloginlib.entity.UserInfo

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_demo)

        EventDefineOfMainEvents.voidEventInJava1().observe(this) {
        }
        EventDefineOfMainEvents.voidEventInJava2().observe(this) {
        }
        EventDefineOfMainEventsKt.voidEventInKotlin1().observe(this) {
        }
        EventDefineOfMainEventsKt.voidEventInKotlin2().observe(this) {
        }
        EventDefineOfMainEventsKt.voidEventInKotlin3().observe(this) {
        }

        EventDefineOfMainEventsKt.genericEvent().observe(this) {
            Log.i(TAG, it!!.joinToString())
        }
    }

    fun onClickNonNullDataEvent(view: View) {
        toast("throw NullEventException.")
        try {
            EventDefineOfMainEvents.nonNullEventInJava().post(null)
        } catch (e: NullEventException) {
            e.printStackTrace()
        }
        try {
            EventDefineOfMainEventsKt.nonNullEventInKotlin().post(null)
        } catch (e: NullEventException) {
            e.printStackTrace()
        }
    }

    fun onClickVoidDataEvent(view: View) {
        toast("Post five void type events.")
        EventDefineOfMainEvents.voidEventInJava1().post(null)
        EventDefineOfMainEvents.voidEventInJava2().post(null)
        EventDefineOfMainEventsKt.voidEventInKotlin1().post(null)
        EventDefineOfMainEventsKt.voidEventInKotlin2().post(null)
        EventDefineOfMainEventsKt.voidEventInKotlin3().post(null)
    }

    fun onClickGenericDataEvent(view: View) {
        toast("Post List<String?> type events.")
        EventDefineOfMainEventsKt.genericEvent().post(listOf(null, "XIAO", "PENG"))
    }

    fun onClickAutoClearEvent(view: View) {
        toast("Except to observe sticky event, but cleared.")
        // Post a event and clear it automatically, cause there are no observers.
        EventDefineOfMainEventsKt.autoClearEvent().post("XIAO PENG")
        val stickyObserver = Observer<String?> {
            // Except to get sticky event, but cleared.
            toast(it!!)
        }
        EventDefineOfMainEventsKt.autoClearEvent().observeSticky(this, stickyObserver)
        // It will try to clear data too.
        EventDefineOfMainEventsKt.autoClearEvent().removeObserver(stickyObserver)
    }

    fun onClickLifecycleObserver(view: View) {
        startActivity(Intent(this, LifecycleObserverDemoActivity::class.java))
    }

    fun onClickDelayEvent(view: View) {
        startActivity(Intent(this, DelayEventDemoActivity::class.java))
    }

    fun onClickStickyEvent(view: View) {
        startActivity(Intent(this, StickyEventDemoActivity::class.java))
    }

    fun testProguard() {
        EventDefineOfLoginEvents.login().observe(this) { user: UserInfo? ->
        }
    }
}