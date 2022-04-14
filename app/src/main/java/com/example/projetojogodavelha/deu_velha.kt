package com.example.projetojogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class deu_velha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deu_velha)

        val jogarDenovo = findViewById<Button>(R.id.jogarNovamente)
        val voltar = findViewById<Button>(R.id.voltar)

        jogarDenovo.setOnClickListener(){
            val intent = Intent(this,jogoMultiplayer::class.java)
            startActivity(intent)
        }
        voltar.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}