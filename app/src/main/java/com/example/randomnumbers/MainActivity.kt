package com.example.randomnumbers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.EditText
import com.example.randomnumbers.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startGame.setOnClickListener{
            val text = binding.numberInput.text.toString()
            if(text == ""){
                Log.e("testing_logger", "invalid input")
                return@setOnClickListener
            }
            val chosenNumber = text.toInt()

            if(chosenNumber >= 1) {
                Globals.randNumber = Random.nextInt(1, chosenNumber)

                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
            }

            binding.numberInput.text = "".toEditable()
        }
    }

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
}