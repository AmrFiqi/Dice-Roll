package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        //Roll the dice/
        rollButton.setOnClickListener { rollDice() }
    }


    private fun rollDice() {
        //Create new dice object.
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Update the view with the random number.
        val diceImage: ImageView = findViewById(R.id.imageView)
        val result= when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(result)
        diceImage.contentDescription = diceRoll.toString()
    }

}
    //Create dice class that returns a random number
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}