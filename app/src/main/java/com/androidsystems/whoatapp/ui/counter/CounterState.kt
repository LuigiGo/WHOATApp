package com.androidsystems.whoatapp.ui.counter

import com.airbnb.mvrx.MavericksState

data class CounterState(val count: Int = 0) : MavericksState