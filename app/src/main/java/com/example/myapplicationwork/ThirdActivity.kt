package com.example.myapplicationwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val buttonBack: Button = findViewById(R.id.buttonBackThirdActivity)
        buttonBack.setOnClickListener({stepToActivityB()})

        val buttonForward: Button = findViewById(R.id.buttonForwardThirdActivity)
        buttonForward.setOnClickListener({stepToActivityA()})
    }

    fun stepToActivityB(){
        val intent  = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun stepToActivityA(){
        val intent  = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}