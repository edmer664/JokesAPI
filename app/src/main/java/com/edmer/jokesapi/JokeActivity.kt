package com.edmer.jokesapi

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.edmer.jokesapi.network.JokeData
import com.edmer.jokesapi.network.JokeInterface
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.joke_layout)
        getJoke();

        val refreshButton = findViewById<FloatingActionButton>(R.id.refresh_btn)
        refreshButton.setOnClickListener {
            getJoke();
            // play sound
            val mp = MediaPlayer.create(this, R.raw.refresh)
            mp.start()

        }
    }

    private fun getJoke() {
        val BASE_URL = "https://v2.jokeapi.dev/"
        val jokeApi = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(JokeInterface::class.java)

        val data = jokeApi.getJoke()
        data.enqueue(object : retrofit2.Callback<JokeData> {
            override fun onFailure(call: retrofit2.Call<JokeData>, t: Throwable) {
                val textView = findViewById<TextView>(R.id.joke_output)
                textView.text = "Error: ${t.message}"
            }

            override fun onResponse(call: retrofit2.Call<JokeData>, response: retrofit2.Response<JokeData>) {
                val responseBody = response.body()
                if (responseBody != null) {
                    val joke = responseBody.joke
                    val jokeText = findViewById<TextView>(
                        R.id.joke_output
                    )
                    jokeText.text = joke
                }
            }
        })
    }
}
