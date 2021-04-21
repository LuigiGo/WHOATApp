package com.androidsystems.whoatapp.ui.reports

import androidx.lifecycle.ViewModel
import com.androidsystems.whoatapp.data.repository.WhoatRepository
import com.androidsystems.whoatapp.utilities.helpers.lazyDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ReportsViewModel(private val repository: WhoatRepository) : ViewModel() {

    val reports by lazyDeferred {
        repository.onReportsLoaded()
    }

    fun loadReports(location: String) {
        CoroutineScope(IO).launch {
            repository.loadReports(location)
        }
    }
}
