package com.example.projetojogodavelha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class vencedor_jogador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vencedor_jogador)

        val reiniciar = findViewById<Button>(R.id.jogarNovamente)
        val telaInicial = findViewById<Button>(R.id.voltar)

        reiniciar.setOnClickListener(){
            val intent = Intent(this, jogoMultiplayer::class.java)
            startActivity(intent)
        }
        telaInicial.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}

