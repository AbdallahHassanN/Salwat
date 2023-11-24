package com.example.slwat.doingSalah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.slwat.databinding.ActivityDoingSalahBinding
import com.example.slwat.db.SalahDatabase
import com.example.slwat.db.SalahRepo
import com.example.slwat.tsgelSalwat.TsgelSalwatVM
import com.example.slwat.tsgelSalwat.TsgelSalwatVMProvider
import java.lang.Exception

class DoingSalah : AppCompatActivity() {
    lateinit var binding: ActivityDoingSalahBinding
    lateinit var doingsalah:DoingSalahVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoingSalahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = SalahRepo(SalahDatabase(this))
        val viewModelProviderFactory = DoingSalahVMProvider(repository)
        doingsalah = ViewModelProvider(this,viewModelProviderFactory).get(DoingSalahVM::class.java)

        doingsalah.getFajrSalahCount(1)
        doingsalah.getDohrSalahCount(2)
        doingsalah.getAsrSalahCount(3)
        doingsalah.getMajharbSalahCount(4)
        doingsalah.getIshaSalahCount(5)



        binding.btnAdd.setOnClickListener {
           if(binding.rbFajr.isChecked ){
               try {
                   doingsalah.elFajr.observe(this, Observer {
                       if(it > 0){
                           doingsalah.deleteSalah(1)
                           Toast.makeText(this,"Salah Done", Toast.LENGTH_SHORT).show()
                       }else {
                           Toast.makeText(this,"No remaining salah", Toast.LENGTH_SHORT).show()
                       }
                   })
               }catch (e: Exception){
                   println("EEEEERRRRRRRRRRRRRRRRROR $e")
               }
           }else if (binding.rbDhuhr.isChecked){
               try {
                   doingsalah.elDohr.observe(this, Observer {
                       if(it > 0){
                           doingsalah.deleteSalah(2)
                           Toast.makeText(this,"Salah Done", Toast.LENGTH_SHORT).show()
                       }else {
                           Toast.makeText(this,"No remaining salah", Toast.LENGTH_SHORT).show()
                       }
                   })
               }catch (e: Exception){
                   println("EEEEERRRRRRRRRRRRRRRRROR $e")
               }
           }else if (binding.rbAsr.isChecked){
               try {
                   doingsalah.elAsr.observe(this, Observer {
                       if(it > 0){
                           doingsalah.deleteSalah(3)
                           Toast.makeText(this,"Salah Done", Toast.LENGTH_SHORT).show()
                       }else {
                           Toast.makeText(this,"No remaining salah", Toast.LENGTH_SHORT).show()
                       }
                   })
               }catch (e: Exception){
                   println("EEEEERRRRRRRRRRRRRRRRROR $e")
               }
           }else if (binding.rbMaghrib.isChecked){
               try {
                   doingsalah.elMajharb.observe(this, Observer {
                       if(it > 0){
                           doingsalah.deleteSalah(4)
                           Toast.makeText(this,"Salah Done", Toast.LENGTH_SHORT).show()
                       }else {
                           Toast.makeText(this,"No remaining salah", Toast.LENGTH_SHORT).show()
                       }
                   })
               }catch (e: Exception){
                   println("EEEEERRRRRRRRRRRRRRRRROR $e")
               }
           }else if (binding.rbIsha.isChecked){
               try {
                   doingsalah.elIsha.observe(this, Observer {
                       if(it > 0){
                           doingsalah.deleteSalah(5)
                           Toast.makeText(this,"Salah Done", Toast.LENGTH_SHORT).show()
                       }else {
                           Toast.makeText(this,"No remaining salah", Toast.LENGTH_SHORT).show()
                       }
                   })
               }catch (e: Exception){
                   println("EEEEERRRRRRRRRRRRRRRRROR $e")
               }
           }
       }
    }
}