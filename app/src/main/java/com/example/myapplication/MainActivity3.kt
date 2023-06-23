package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val tvName: TextView = findViewById(R.id.tvName)         // declaring user name var for this activity
        var tvScore: TextView = findViewById(R.id.tvScore)       // declaring user score var for this activity
        var btnFinish: Button = findViewById(R.id.finish)        // declaring finish btn var for this activity

        tvName.text = intent.getStringExtra(Constants.userName)         // getting value from intent and putting it on text property
        val totalQuestions = intent.getIntExtra(Constants.totalQuestions,0)  // declaring and initializing var to get total number of questions from intent
        val correctAns = intent.getIntExtra(Constants.correctAnswers, 0)     // declaring and initializing var to get total number of correct answers from intent

        tvScore.text = "Your total score is $correctAns out of $totalQuestions."  // making the correct text to display on the result screen

        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))   // when btn is clicked we will be redirected to activity main 1
        }
    }
}