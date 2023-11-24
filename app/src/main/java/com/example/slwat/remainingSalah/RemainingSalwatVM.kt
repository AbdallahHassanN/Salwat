package com.example.slwat.remainingSalah

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.slwat.db.SalahRepo
import com.example.slwat.model.Salah
import kotlinx.coroutines.launch

class RemainingSalwatVM(private val salahRepo: SalahRepo): ViewModel() {

    val elFajr:MutableLiveData<Int> = MutableLiveData()
    val elDohr:MutableLiveData<Int> = MutableLiveData()
    val elAsr:MutableLiveData<Int> = MutableLiveData()
    val elMajharb:MutableLiveData<Int> = MutableLiveData()
    val elIsha:MutableLiveData<Int> = MutableLiveData()


    fun getFajrSalahCount(salahNo:Int) = viewModelScope.launch {
        elFajr.postValue(salahRepo.getSalahCount(salahNo))
    }
    fun getDohrSalahCount(salahNo:Int) = viewModelScope.launch {
        elDohr.postValue(salahRepo.getSalahCount(salahNo))
    }
    fun getAsrSalahCount(salahNo:Int) = viewModelScope.launch {
        elAsr.postValue(salahRepo.getSalahCount(salahNo))
    }
    fun getMajharbSalahCount(salahNo:Int) = viewModelScope.launch {
        elMajharb.postValue(salahRepo.getSalahCount(salahNo))
    }
    fun getIshaSalahCount(salahNo:Int) = viewModelScope.launch {
        elIsha.postValue(salahRepo.getSalahCount(salahNo))
    }
}