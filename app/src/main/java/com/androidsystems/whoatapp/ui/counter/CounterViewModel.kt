package com.androidsystems.whoatapp.ui.counter

import com.airbnb.mvrx.MavericksViewModel

class CounterViewModel(
    initialState: CounterState
) : MavericksViewModel<CounterState>(initialState) {

    fun incrementCount() {
        setState {
            copy(count = count + 1)
        }
    }

}