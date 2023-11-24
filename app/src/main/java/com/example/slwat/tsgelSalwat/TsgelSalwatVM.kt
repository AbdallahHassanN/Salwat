package com.example.slwat.tsgelSalwat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.slwat.db.SalahRepo
import kotlinx.coroutines.launch

class TsgelSalwatVM(private val salahRepo: SalahRepo): ViewModel() {

    fun updateSalah(salahNo:Int) = viewModelScope.launch {
        salahRepo.updateSalahCount(salahNo)
    }
}