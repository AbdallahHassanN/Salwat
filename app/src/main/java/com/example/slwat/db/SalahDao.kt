package com.example.slwat.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.slwat.model.Salah

@Dao
interface SalahDao {

   /*@Query("Update Salah SET salahCount = salahCount + 1 Where salahId = :salahId")
   suspend fun updateSalahCount(salahId:Int)*/

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun upsert(salah: MutableList<Salah>)

   @Query("Update Salah SET salahCount = salahCount + 1 Where salahNo = :salahNo")
   suspend fun updateSalahCount(salahNo:Int)

   @Query("Update Salah SET salahCount = salahCount - 1 Where salahId = :salahId AND salahCount > 0")
   suspend fun deleteSalahCount(salahId:Int)

   /*@Query("SELECT * FROM Salah where salahId = :salahId")
   fun getSalahCount(salahId: Int): LiveData<List<Salah>>*/

   /*@Query("SELECT * FROM Salah where salahNo = :salahNo")
   fun getSalahCount(salahNo:Int): LiveData<List<Salah>>*/

   @Query("SELECT salahCount FROM Salah where salahNo = :salahNo")
   suspend fun getSalahCount(salahNo:Int): Int
}