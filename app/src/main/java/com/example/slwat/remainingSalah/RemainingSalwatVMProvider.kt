package com.example.slwat.remainingSalah

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.slwat.db.SalahRepo

class RemainingSalwatVMProvider(
    val salahRepo: SalahRepo
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RemainingSalwatVM(salahRepo) as T
    }
}