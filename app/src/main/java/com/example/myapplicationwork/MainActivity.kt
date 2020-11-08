package com.example.myapplicationwork

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonForward: Button = findViewById(R.id.buttonForwardMainActivity)
        buttonForward.setOnClickListener({stepToActivityB()})
    }

    fun stepToActivityB(){
        val intent: Intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}