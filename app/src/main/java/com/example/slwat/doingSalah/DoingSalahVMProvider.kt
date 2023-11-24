package com.example.slwat.doingSalah

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.slwat.db.SalahRepo

class DoingSalahVMProvider(
    val salahRepo: SalahRepo
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DoingSalahVM(salahRepo) as T
    }
}