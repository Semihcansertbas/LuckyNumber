package com.example.lucknumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val b1: Button = findViewById(R.id.btn)
        val editTxt: EditText = findViewById(R.id.editText)

        b1.setOnClickListener {
            var userName = editTxt.text
            // Explicit Intents
            var i = Intent(this, LuckNumberActivity::class.java)
            // Passing the username
            i.putExtra("name", userName)
            startActivity(i);

        }

    }
}