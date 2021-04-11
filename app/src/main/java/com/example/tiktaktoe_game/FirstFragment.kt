package com.example.tiktaktoe_game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    companion object {
        var player1 = "Player 1"
        var player2 = "Player 2"
    }

    lateinit var editText: EditText

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            player1 = view.findViewById<EditText>(R.id.player1).getText().toString()
            player2 = view.findViewById<EditText>(R.id.player2).getText().toString()
            if(player1.isEmpty()){
                player1 = "Player 1"
            }
            if(player2.isEmpty()){
                player2 = "Player 2"
            }
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}