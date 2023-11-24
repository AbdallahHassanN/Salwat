package com.example.slwat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.slwat.databinding.ActivityMainBinding
import com.example.slwat.doingSalah.DoingSalah
import com.example.slwat.remainingSalah.RemainingSalwat
import com.example.slwat.tsgelSalwat.TsgelSalwat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cvSalwat.setOnClickListener {
            val intent = Intent(this, RemainingSalwat::class.java)
            startActivity(intent)
        }
        binding.cvTsgel.setOnClickListener {
            val intent = Intent(this, TsgelSalwat::class.java)
            startActivity(intent)
        }
        binding.cvDoingSalwat.setOnClickListener {
            val intent = Intent(this, DoingSalah::class.java)
            startActivity(intent)
        }
    }
}