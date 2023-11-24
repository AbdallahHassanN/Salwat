package com.example.slwat.tsgelSalwat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.slwat.databinding.ActivityTsgelSalwatBinding
import com.example.slwat.db.SalahDatabase
import com.example.slwat.db.SalahRepo
import java.lang.Exception


class TsgelSalwat : AppCompatActivity() {
    lateinit var binding: ActivityTsgelSalwatBinding
    lateinit var tsgelViewModel:TsgelSalwatVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTsgelSalwatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = SalahRepo(SalahDatabase(this))
        val viewModelProviderFactory = TsgelSalwatVMProvider(repository)
        tsgelViewModel = ViewModelProvider(this,viewModelProviderFactory).get(TsgelSalwatVM::class.java)

        binding.btnAdd.setOnClickListener {
            if(binding.rbFajr.isChecked){
                try {
                    tsgelViewModel.updateSalah(1)
                    Toast.makeText(this,"Salah Added", Toast.LENGTH_SHORT).show()
                }catch (e:Exception){
                    println("EEEEERRRRRRRRRRRRRRRRROR $e")
                }
            } else if(binding.rbDhuhr.isChecked){
                try {
                    tsgelViewModel.updateSalah(2)
                    Toast.makeText(this,"Salah Added", Toast.LENGTH_SHORT).show()
                }catch (e:Exception){
                    println("EEEEERRRRRRRRRRRRRRRRROR $e")
                }
            }
            else if(binding.rbAsr.isChecked){
                try {
                    tsgelViewModel.updateSalah(3)
                    Toast.makeText(this,"Salah Added", Toast.LENGTH_SHORT).show()
                }catch (e:Exception){
                    println("EEEEERRRRRRRRRRRRRRRRROR $e")
                }
            }
            else if(binding.rbMaghrib.isChecked){
                try {
                    tsgelViewModel.updateSalah(4)
                    Toast.makeText(this,"Salah Added", Toast.LENGTH_SHORT).show()
                }catch (e:Exception){
                    println("EEEEERRRRRRRRRRRRRRRRROR $e")
                }
            }
            else if(binding.rbIsha.isChecked){
                try {
                    tsgelViewModel.updateSalah(5)
                    Toast.makeText(this,"Salah Added", Toast.LENGTH_SHORT).show()
                }catch (e:Exception){
                    println("EEEEERRRRRRRRRRRRRRRRROR $e")
                }
            }
        }
    }
}