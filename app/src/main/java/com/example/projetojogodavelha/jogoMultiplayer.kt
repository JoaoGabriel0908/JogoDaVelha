package com.example.projetojogodavelha

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.X
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class jogoMultiplayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo_multiplayer)
    }

    fun btClick(view: View){
        val btnSelecionado = view as ImageButton
        var cellId = 0

        when(btnSelecionado.id){
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
        // Toast.makeText(this, "ID: " + cellId, Toast.LENGTH_SHORT).show()
        playGame(cellId, btnSelecionado)
    }
    // Criando variáveis para cada jogador
    var contador = 0

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var playerAtual = 1

    // Arrays para guardar as jogadas dos jogadores
    fun verificarPlayer (player: ArrayList<Int>): Boolean{
        return player.contains(1) && player.contains(2) && player.contains(3) ||
                player.contains(4) && player.contains(5) && player.contains(6) ||
                player.contains(7) && player.contains(8) && player.contains(9) ||
                player.contains(1) && player.contains(4) && player.contains(7) ||
                player.contains(2) && player.contains(5) && player.contains(8) ||
                player.contains(3) && player.contains(6) && player.contains(9) ||
                player.contains(1) && player.contains(5) && player.contains(9) ||
                player.contains(3) && player.contains(5) && player.contains(7)
    }

    // Validando quem está jogando
    fun playGame(cellId:Int, btnSelecionado:ImageButton){

        contador++

        if (playerAtual==1){
            btnSelecionado.setImageResource(R.drawable.x3)
            player1.add(cellId)
            playerAtual = 2
        } else{
            btnSelecionado.setImageResource(R.drawable.ellipse4)
            player2.add(cellId)
            playerAtual = 1
        }
    btnSelecionado.isEnabled = false

        checkWiner()
    }

    fun checkWiner() {
        var winer = 0

        if (verificarPlayer(player1)) {
            winer = 1
        } else if (verificarPlayer(player2)) {
            winer = 2
        } else {
            winer = 3
        }

        //Winer
        if (winer!=0){
            if (winer == 1){
                val intent = Intent(this, vencedor_jogador::class.java)
                startActivity(intent)
            }else if(winer == 2){
                val intent = Intent(this, vencedor_jogador::class.java)
                startActivity(intent)
            } else if(contador >= 9 && winer == 3){
                val intent = Intent(this, deu_velha::class.java)
                startActivity(intent)
            }
        }

    }

}

private fun ImageButton.setImageDrawable(x3: Int) {

}
