package com.pengxr.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pengxr.modular.eventbus.generated.events.EventDefineOfMainEventsKt
import com.pengxr.sample.utils.toast

class LifecycleObserverDemoActivity : AppCompatActivity() {

    companion object {
        var lifecycleObserverConut = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_observer_demo)
    }

    // Register observers without remove them, test whether they will be after owner destroyed.
    fun onClickLifecycleObserver(view: View) {
        toast("Register 2 observers.")
        val newCount1 = ++lifecycleObserverConut
        EventDefineOfMainEventsKt.lifecycleObserverEvent().observe(this) {
            toast("Receive delayed event from observer, observer no.$newCount1.")
        }
        val newCount2 = ++lifecycleObserverConut
        EventDefineOfMainEventsKt.lifecycleObserverEvent().observeSticky(this) {
            toast("Receive delayed event from sticky observer, observer no.$newCount2.")
        }
    }

    fun onClickPostEvent(view: View) {
        EventDefineOfMainEventsKt.lifecycleObserverEvent().post("XIAO PENG")
    }
}