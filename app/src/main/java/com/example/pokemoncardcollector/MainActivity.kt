package com.example.pokemoncardcollector

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemoncardcollector.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}