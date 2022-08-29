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

    fun onClickLifecycleObserver(view: View) {
        // Register observers without remove them, test whether they will be after owner destroyed.
        val newCount = ++lifecycleObserverConut
        EventDefineOfMainEventsKt.lifecycleObserverEvent().observe(this) {
            toast("Observer num: $newCount")
        }
        EventDefineOfMainEventsKt.lifecycleObserverEvent().observeSticky(this) {
            toast("Sticky Observer num: $newCount")
        }
        EventDefineOfMainEventsKt.lifecycleObserverEvent().post("XIAO PENG")
    }
}