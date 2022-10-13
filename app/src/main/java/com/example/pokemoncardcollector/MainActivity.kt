package com.example.pokemoncardcollector

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pokemoncardcollector.apiclasses.CardData
import com.example.pokemoncardcollector.apiclasses.Datum
import com.example.pokemoncardcollector.apiclasses.Holofoil
import com.example.pokemoncardcollector.databinding.ActivityMainBinding
import com.example.pokemoncardcollector.entities.Card
import com.example.pokemoncardcollector.fragments.AddFragment.Companion.BaseUrl
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))

    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.fragmentContainerView)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}