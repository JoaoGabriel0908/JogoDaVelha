package com.example.projetojogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DificuldadeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dificuldade)

        val jogoFacil = findViewById<TextView>(R.id.facil)
        val jogoMedio = findViewById<TextView>(R.id.medio)
        val jogoDificil = findViewById<TextView>(R.id.impossivel)

        jogoFacil.setOnClickListener(){
            val intent = Intent(this, jogo_computador::class.java)
            startActivity(intent)
        }
        jogoMedio.setOnClickListener(){
            val intent = Intent(this, jogo_computador::class.java)
            startActivity(intent)
        }
        jogoDificil.setOnClickListener(){
            val intent = Intent(this, jogo_computador::class.java)
            startActivity(intent)
        }
    }
}