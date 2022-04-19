package com.example.projetojogodavelha

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

var cellId = 0

class jogo_computador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_computador)

    }

    fun btnClick(view: View) {
        val btnSelecionado = view as ImageButton

        when (btnSelecionado.id) {
            R.id.but1 -> cellId = 1
            R.id.but2 -> cellId = 2
            R.id.but3 -> cellId = 3
            R.id.but4 -> cellId = 4
            R.id.but5 -> cellId = 5
            R.id.but6 -> cellId = 6
            R.id.but7 -> cellId = 7
            R.id.but8 -> cellId = 8
            R.id.but9 -> cellId = 9
        }
        Toast.makeText(this, "ID: " + cellId, Toast.LENGTH_SHORT).show()
        jogadorDaVez(cellId, btnSelecionado)
    }

    // Criando variáveis para cada jogador
    var contador = 0

    var jogador = ArrayList<Int>()
    var computador = ArrayList<Int>()

    var playerAtual = 1

    // Validando quem está jogando
    fun jogadorDaVez(cellId: Int, btnSelecionado: ImageButton) {

        contador++

        if (playerAtual == 1) {
            btnSelecionado.setImageResource(R.drawable.x3)
            jogador.add(cellId)
            playerAtual = 2
        } else {
            btnSelecionado.setOnClickListener(View.OnClickListener {
                Random.nextInt(cellId)
                btnSelecionado.setImageResource(R.drawable.o)
                computador.add(Random.nextInt(cellId))
            })
            playerAtual = 1
        }
        btnSelecionado.isEnabled = false
    }

    private fun jogoDaMaquina() {

        val numeroSorteado = (1..9).random()
        lateinit var btnSelecionado: Button


        when (numeroSorteado) {
            1 -> btnSelecionado = findViewById(R.id.but1)
            2 -> btnSelecionado = findViewById(R.id.but2)
            3 -> btnSelecionado = findViewById(R.id.but3)
            4 -> btnSelecionado = findViewById(R.id.but4)
            5 -> btnSelecionado = findViewById(R.id.but5)
            6 -> btnSelecionado = findViewById(R.id.but6)
            7 -> btnSelecionado = findViewById(R.id.but7)
            8 -> btnSelecionado = findViewById(R.id.but8)
            9 -> btnSelecionado = findViewById(R.id.but9)
        }
        btnSelecionado.background = getDrawable(R.drawable.o)
        computador.add(numeroSorteado)

        playerAtual = 1
    }

    // Arrays para guardar as jogadas dos jogadores
    fun verificarPlayer(player: ArrayList<Int>): Boolean {
        return player.contains(1) && player.contains(2) && player.contains(3) ||
                player.contains(4) && player.contains(5) && player.contains(6) ||
                player.contains(7) && player.contains(8) && player.contains(9) ||
                player.contains(1) && player.contains(4) && player.contains(7) ||
                player.contains(2) && player.contains(5) && player.contains(8) ||
                player.contains(3) && player.contains(6) && player.contains(9) ||
                player.contains(1) && player.contains(5) && player.contains(9) ||
                player.contains(3) && player.contains(5) && player.contains(7)
    }

    fun checarVencedor() {
        var vencedor = 0

        if (verificarPlayer(jogador)) {
            vencedor = 2

        } else if (verificarPlayer(computador)) {
            vencedor = 1
        } else if (contador >= 9 && vencedor == 0) {
            vencedor = 3
        }


        //VENCEDOR
        if (vencedor != 0) {
            if (vencedor == 1) {
                val intent = Intent(this, vencedor_jogador::class.java)
                intent.putExtra("gonW", "10")
                startActivity(intent)
            } else if (vencedor == 2) {
                val intent = Intent(this, vencedor_jogador::class.java)
                intent.putExtra("killW", "20")
                startActivity(intent)
            } else if (vencedor == 3) {
                val intent = Intent(this, vencedor_jogador::class.java)
                startActivity(intent)
            }
        }

    }
}