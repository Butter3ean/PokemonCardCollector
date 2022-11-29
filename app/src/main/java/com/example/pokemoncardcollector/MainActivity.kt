package com.example.pokemoncardcollector

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemoncardcollector.databinding.ActivityMainBinding
import com.example.pokemoncardcollector.viewmodels.ImageViewModel

private lateinit var binding: ActivityMainBinding

//items that should be added to the application in no necessary order of what should be completed
//DONE: add confirmation of deleting a card after long pressing
//DONE: remove delete all button and add delete all into a menu
//TODO: when clicking on a card, pulls up a full screen of the card with details of the card in a scrollable view
//TODO: Text recognition to scan cards
//TODO: Add a page view to how the cards are seen instead of scrolling through all of them
//TODO: Add more sorting options to how cards are viewed; i.e. sorting by element type, card type, national dex num, etc
//TODO: Fix issues with database and the information about a card it holds
//TODO: Update price column for each card periodically
//DONE: Add a title screen to the app
//TODO: add an option to create multiple collections
//TODO: change the way the api is searched by using card name, set name, and card number
//TODO: add changeable backgrounds for users background
//TODO: able to add multiple copies of a card instead of only single cards
//DONE: Fix the formatting of prices of cards


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }






}