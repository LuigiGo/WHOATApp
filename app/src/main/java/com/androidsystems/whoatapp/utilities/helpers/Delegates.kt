package com.androidsystems.whoatapp.utilities.helpers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart.LAZY
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

// Note:Why we need this? We need to use lazy to initialized the call only when it is ready.
// also, for calling the repository function, we need to use "by lazy", but since it is not
// providing coroutine context and a suspend block using Coroutine Scope, we created this class.
// Please refer to the CurrentWeatherViewModel class particular in line "val weather by lazyDeferred"
fun <T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = LAZY) {
            block.invoke(this)
        }
    }
}