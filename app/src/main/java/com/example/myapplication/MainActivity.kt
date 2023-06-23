package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btnStart: Button = findViewById(R.id.btnStart)  // initializing  start button which will take us to exam
        var etName: EditText = findViewById(R.id.etName)    // initializing  name Text field , where user will ask name
        btnStart.setOnClickListener(){               // putting on click listener on start button
            if(etName.text.isEmpty()){                      // we wont let the user to proceed without name
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()  // simple toast message
            }else{                                           // if name is provided
                val intent= Intent(this, MainActivity2::class.java)  //initializing object of intent class for activity 2
                intent.putExtra(Constants.userName, etName.text.toString())   //add etName text to intent object and assigning Constant username as its key and passing it
                startActivity(intent)                         // it will start main activity 2 and also pass extra info
                finish()                                      // it will finish the current activity
            }
        }

    }
}