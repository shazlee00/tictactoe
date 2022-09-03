package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var playerTurn="X"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var playerTurnTxt:TextView=findViewById(R.id.player_turn)
        playerTurnTxt.text="Player $playerTurn turn"
        val gameBoard= mutableListOf<Button>(
            findViewById(R.id.button11),
        findViewById(R.id.button12),
        findViewById(R.id.button13),
        findViewById(R.id.button21),
        findViewById(R.id.button22),
        findViewById(R.id.button23),
        findViewById(R.id.button31),
        findViewById(R.id.button32),
            findViewById(R.id.button33)

        )


        for(button in gameBoard)
        {
            button.setOnClickListener{
                if(button.text != "")
               else if(playerTurn=="X")
                {
                    button.text="X"
                 when(checkBoard(gameBoard))
                    {
                        "C" -> {playerTurn="O"; playerTurnTxt.text="Player $playerTurn turn"}
                        "F" -> {playerTurn="X"; playerTurnTxt.text="DRAW" ;for(button in gameBoard) button.text="";}

                        else -> {playerTurn="X"; playerTurnTxt.text="PLAYER ${checkBoard(gameBoard)} WINS ";for(button in gameBoard) button.text=""      }
                    }


                }
                else if(playerTurn=="O")
                {
                    button.text="O"
                    when(checkBoard(gameBoard))
                    {
                        "C" -> {playerTurn="X"; playerTurnTxt.text="Player $playerTurn turn"}
                        "F" -> {playerTurn="X"; playerTurnTxt.text="DRAW" ;for(button in gameBoard) button.text=""}

                        else -> {playerTurn="X"; playerTurnTxt.text="PLAYER ${checkBoard(gameBoard)} WINS " ;for(button in gameBoard) button.text=""     }
                    }
                }
            }
        }




    }

    private fun checkBoard(gameBoard: MutableList<Button>): CharSequence? {

        //rows
        if(gameBoard.slice(0..2).all{it.text=="X"}) return "X"
        else if(gameBoard.slice(0..2).all{it.text=="O"}) return "O"

        if(gameBoard.slice(3..5).all{it.text=="X"}) return "X"
        else if(gameBoard.slice(3..5).all{it.text=="O"}) return "O"

        if(gameBoard.slice(6..8).all{it.text=="X"}) return "X"

        else if(gameBoard.slice(6..8).all{it.text=="O"}) return "O"
        //Columbs
        if(gameBoard.slice(0..6 step 3).all{it.text=="X"})  return "X"

        else if(gameBoard.slice(0..6 step 3).all{it.text=="O"}) return "O"

        if(gameBoard.slice(1..7 step 3).all{it.text=="X"})  return "X"

        else if(gameBoard.slice(1..7 step 3).all{it.text=="O"}) return "O"


        if(gameBoard.slice(2..8 step 3).all{it.text=="X"})  return "X"


        else if(gameBoard.slice(2..8 step 3).all{it.text=="O"}) return "O"

        //cross
        if(gameBoard.slice(setOf(0, 4 , 8)).all{it.text=="X"}) 	return "X"

        else if(gameBoard.slice(setOf(0, 4 , 8)).all{it.text=="O"}) return "O"

        if(gameBoard.slice(setOf(2, 4 , 6)).all{it.text=="X"})    return "X"

        else if(gameBoard.slice(setOf(2, 4 , 6)).all{it.text=="O"}) return "O"

        for(button in gameBoard) {
            if (button.text == "") {
                return "C"
            }
        }
        return "F"
    }


}

