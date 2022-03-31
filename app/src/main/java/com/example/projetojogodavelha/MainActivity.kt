package com.example.projetojogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerComp = findViewById<Button>(R.id.playerComputer)
        val playerPlay = findViewById<Button>(R.id.playerPlayer)

        playerComp.setOnClickListener(){
            val intent = Intent(this, DificuldadeActivity::class.java)
            startActivity(intent)
        }
        playerPlay.setOnClickListener(){
            val intent = Intent(this, jogoMultiplayer::class.java)
            startActivity(intent)
        }
    }
}