package work.nbcc.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity(){

    private lateinit var rollButton : Button
    private lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.do_it_button).setOnClickListener{
            findViewById<ImageView>(R.id.dice1_image).setImageResource(rollDice())
            findViewById<ImageView>(R.id.dice2_image).setImageResource(rollDice())
            findViewById<ImageView>(R.id.dice3_image).setImageResource(rollDice())

        }


        rollButton.setOnClickListener{
            diceImage.setImageResource(rollDice())
        }


    }



    private fun rollDice() : Int{
        return when((1..6).random()){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

    }

}
