package com.example.tiktaktoe_game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
//@SuppressWarnings("ResourceType")
class SecondFragment : Fragment() {

    var turnCount = 0
    var gameField = arrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)

    fun checkGameEnd(): Int{
        //Parbauda vertikali
        for(i in 0..2){
            if(gameField[i] == gameField[i+3] && gameField[i] == gameField[i+6]){
                return gameField[i]
            }
        }

        //Parbauda horizontali
        for(i in 0..6 step 3){
            if(gameField[i] == gameField[i+1] && gameField[i] == gameField[i+2]){
                return gameField[i]
            }
        }

        //Parbauda diagonales
        if(gameField[0] == gameField[4] && gameField[0] == gameField[8]){
            return gameField[0]
        }

        if(gameField[2] == gameField[4] && gameField[2] == gameField[6]){
            return gameField[2]
        }

        //Parbauda draw
        var draw = true
        for(i in 0..8){
            if (gameField[i] == -1){
                draw = false
            }
        }
        if (draw){
            return 2
        }

        return -1
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        view.findViewById<Button>(R.id.spot0).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot0Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[0] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[0] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
        }

        view.findViewById<Button>(R.id.spot1).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot1Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[1] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[1] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
        }

        view.findViewById<Button>(R.id.spot2).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot2Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[2] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[2] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
        }

        view.findViewById<Button>(R.id.spot3).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot3Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[3] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[3] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
        }

        view.findViewById<Button>(R.id.spot4).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot4Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[4] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[4] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
        }

        view.findViewById<Button>(R.id.spot5).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot5Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[5] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[5] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
        }

        view.findViewById<Button>(R.id.spot6).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot6Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[6] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[6] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
        }

        view.findViewById<Button>(R.id.spot7).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot7Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[7] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[7] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
        }

        view.findViewById<Button>(R.id.spot8).setOnClickListener {
            val img: ImageView = view.findViewById<ImageView>(R.id.spot8Img) as ImageView
            if(turnCount%2==0){
                img.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
                gameField[8] = 0
            }else{
                img.setImageResource(android.R.drawable.radiobutton_off_background)
                gameField[8] = 1
            }
            val finishCheck = checkGameEnd()
            var checker = false
            if(finishCheck == 0){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 1){
                view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " WINS")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }else if(finishCheck == 2){
                view.findViewById<TextView>(R.id.finish_message).setText("GAME DRAW")
                view.findViewById<Button>(R.id.button_second).setText("New Game")
                checker = true
            }
            if(checker){
                //Game end
                view.findViewById<Button>(R.id.spot0).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot1).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot2).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot3).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot4).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot5).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot6).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot7).setVisibility(View.GONE)
                view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
            }else{
                //Next player move
                if(turnCount%2==0){
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player2 + " MOVE")
                }else{
                    view.findViewById<TextView>(R.id.finish_message).setText(FirstFragment.player1 + " MOVE")
                }
            }
            turnCount++
            view.findViewById<Button>(R.id.spot8).setVisibility(View.GONE)
        }

    }
}