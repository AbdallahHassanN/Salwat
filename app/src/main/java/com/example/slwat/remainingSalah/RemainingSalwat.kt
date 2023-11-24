package com.example.slwat.remainingSalah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.slwat.databinding.ActivityRemainingSalwatBinding
import com.example.slwat.db.SalahDatabase
import com.example.slwat.db.SalahRepo
import com.example.slwat.model.Salah
import com.example.slwat.tsgelSalwat.TsgelSalwatVMProvider

class RemainingSalwat : AppCompatActivity() {
    lateinit var binding: ActivityRemainingSalwatBinding
    lateinit var remainingViewModel: RemainingSalwatVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRemainingSalwatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = SalahRepo(SalahDatabase(this))
        val viewModelProviderFactory = RemainingSalwatVMProvider(repository)
        remainingViewModel = ViewModelProvider(this,viewModelProviderFactory).get(RemainingSalwatVM::class.java)

        remainingViewModel.getFajrSalahCount(1)
        remainingViewModel.getDohrSalahCount(2)
        remainingViewModel.getAsrSalahCount(3)
        remainingViewModel.getMajharbSalahCount(4)
        remainingViewModel.getIshaSalahCount(5)

        remainingViewModel.elFajr.observe(this, Observer {
           println("AAAAAAAAAAAAAAAA $it")
           binding.tvFajrCount.text = it.toString()
       })
        remainingViewModel.elDohr.observe(this, Observer {
            println("AAAAAAAAAAAAAAAA $it")
            binding.tvDohrCount.text = it.toString()
        })
        remainingViewModel.elAsr.observe(this, Observer {
            println("AAAAAAAAAAAAAAAA $it")
            binding.tvAsrCount.text = it.toString()
        })
        remainingViewModel.elMajharb.observe(this, Observer {
            println("AAAAAAAAAAAAAAAA $it")
            binding.tvMaghribCount.text = it.toString()
        })
        remainingViewModel.elIsha.observe(this, Observer {
            println("AAAAAAAAAAAAAAAA $it")
            binding.tvIshaCount.text = it.toString()
        })
    }
}