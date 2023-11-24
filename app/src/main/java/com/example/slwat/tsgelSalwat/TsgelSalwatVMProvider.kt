package com.example.slwat.tsgelSalwat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.slwat.db.SalahRepo

class TsgelSalwatVMProvider(
    val salahRepo: SalahRepo
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TsgelSalwatVM(salahRepo) as T
    }
}