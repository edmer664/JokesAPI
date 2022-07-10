package com.edmer.jokesapi

import android.content.ClipData.newIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get welcome_btn set to button variable
        val button = findViewById<Button>(R.id.welcome_btn)
        // Set onClickListener to button
        button.setOnClickListener {
            // Create new intent to open JokeActivity
            val intent = Intent(this, JokeActivity::class.java)
            // Start new intent
            startActivity(intent)
        }

    }
    
}