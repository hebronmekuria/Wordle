package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //intialize main guess edittext
        var input=findViewById<EditText>(R.id.editText)
        //intialize TextViews of guesses
        var ans1=findViewById<TextView>(R.id.userguess1)
        var ans2=findViewById<TextView>(R.id.userguess2)
        var ans3=findViewById<TextView>(R.id.userguess3)
        //intialize TextViews of responses the person receives
        var res1=findViewById<TextView>(R.id.result1)
        var res2=findViewById<TextView>(R.id.result2)
        var res3=findViewById<TextView>(R.id.result3)
        //initialize a variable to keep count of how many tries the person gets
        var count=0
        var randomwrd=FourLetterWordList.getRandomFourLetterWord()
        var ans = findViewById<TextView>(R.id.mainguess)
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener{
            count++
            if (count==1) {
                ans1.text=input.text
                res1.text=checkGuess(ans1.text.toString(), randomwrd)
                input.text.clear()

            }
            if (count==2) {
                ans2.text=input.text
                res2.text=checkGuess(ans2.text.toString(), randomwrd)
                input.text.clear()
            }
            if (count==3) {
                ans3.text=input.text
                res3.text=checkGuess(ans3.text.toString(), randomwrd)
                input.text.clear()
                ans.text = randomwrd
            }
            if (count > 3 && input.toString() != randomwrd) {
                Toast.makeText(applicationContext, "You Lose", Toast.LENGTH_SHORT)
                ans.text = randomwrd
            }

        }




    }
    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    //intialize WordleWord

    private fun checkGuess(guess1: String, wordToGuess: String) : String {
        var guess = guess1.uppercase()
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}