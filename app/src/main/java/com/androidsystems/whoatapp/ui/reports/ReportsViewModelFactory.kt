package com.androidsystems.whoatapp.ui.reports

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androidsystems.whoatapp.data.repository.WhoatRepository

class ReportsViewModelFactory(private val repository: WhoatRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReportsViewModel(repository) as T
    }
}