package com.androidsystems.whoatapp.ui.counter

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.mvrx.MavericksView
import com.androidsystems.whoatapp.R

class CounterActivity : AppCompatActivity(), MavericksView {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_counter)
    }

    override fun invalidate() {

    }
}