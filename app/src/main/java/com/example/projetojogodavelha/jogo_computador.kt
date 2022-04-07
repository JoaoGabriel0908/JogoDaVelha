package com.example.projetojogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class jogo_computador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_computador)

        val jogoFacil = findViewById<TextView>(R.id.facil)
        val jogoMedio = findViewById<TextView>(R.id.medio)
        val jogoDificil = findViewById<TextView>(R.id.impossivel)

        jogoFacil.setOnClickListener(){

        }
    }
}