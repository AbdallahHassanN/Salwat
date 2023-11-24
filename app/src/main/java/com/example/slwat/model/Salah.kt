package com.example.slwat.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Salah"
)
data class Salah(
    @PrimaryKey(autoGenerate = true)
    val salahId: Int?=null,
    val salahNo:Int?= null,
    val salahName: String,
    val salahCount: Int,
)