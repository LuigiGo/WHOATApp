package com.androidsystems.whoatapp.ui.reports

import androidx.lifecycle.ViewModel
import com.androidsystems.whoatapp.data.repository.WhoatRepository
import com.androidsystems.whoatapp.utilities.helpers.lazyDeferred

class ReportsViewModel(private val repository: WhoatRepository) : ViewModel() {

    var location: String = ""

    val reports by lazyDeferred {
        repository.getReports(location)
    }
}
