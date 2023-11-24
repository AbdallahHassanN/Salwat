package com.example.slwat.db

import androidx.lifecycle.LiveData
import com.example.slwat.model.Salah

class SalahRepo(
val db:SalahDatabase
) {

    suspend fun deleteSalahCount(salahId: Int) = db.getSalahDao().deleteSalahCount(salahId)

    suspend fun updateSalahCount(salahNo: Int) = db.getSalahDao().updateSalahCount(salahNo)

    suspend fun getSalahCount(salahNo: Int): Int {
        return db.getSalahDao().getSalahCount(salahNo)
    }
}