package com.example.myapplicationwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonBack: Button = findViewById(R.id.buttonBackSecondActivity)
        buttonBack.setOnClickListener({stepToActivityA()})

        val buttonForward: Button = findViewById(R.id.buttonForwardSecondActivity)
        buttonForward.setOnClickListener({stepToActivityC()})
    }

    fun stepToActivityA(){
        val intent  = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun stepToActivityC(){
        val intent  = Intent(this, ThirdActivity::class.java)
    //    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    //    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent)
    }
}