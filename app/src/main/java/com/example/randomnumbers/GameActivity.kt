package com.example.randomnumbers

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.randomnumbers.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    lateinit var binding: ActivityGameBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        var guesses = 0
        var gameOn = true
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkAnswer.setOnClickListener {
            guesses += 1
            if(!gameOn) return@setOnClickListener
            val trueAnswer = Globals.randNumber
            val text = binding.answerInput.text.toString()
            if(text == ""){
                Log.e("testing_logger", "invalid input")
                return@setOnClickListener
            }
            val chosenNumber = text.toInt()

            if(chosenNumber == trueAnswer){
                binding.returnedText.text = "Gratulacje! poprawna odpowiedź, potrzebowałeś $guesses prób"
                gameOn = false
            } else if(trueAnswer < chosenNumber){
                binding.returnedText.text = "x < $chosenNumber"
            } else {
                binding.returnedText.text = "x > $chosenNumber"
            }
        }
    }
}