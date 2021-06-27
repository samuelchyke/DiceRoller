package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(my_toolbar)

        setDice()

        val rollButton: Button = button
        rollButton.setOnClickListener {
            rollImageDice()
        }


    }

    private fun setDice(){
        val diceImage: ImageView = imageView
        diceImage.setImageResource(R.drawable.dice_1)
    }


    private fun rollImageDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = imageView

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
    }


//    private fun rollDice() {
//        // Create new Dice object with 6 sides and roll it
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//
//        // Update the screen with the dice roll
//        val resultTextView: TextView = textView
//        resultTextView.text = diceRoll.toString()
//
//        val luckyNumber = 4
//
//        val luckyNumberTextView: TextView = textView2
//        if (diceRoll == luckyNumber) {
//            luckyNumberTextView.text = "You win!"
//        } else {
//            luckyNumberTextView.text = "You didn't win, try again!"
//        }
//    }

}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}