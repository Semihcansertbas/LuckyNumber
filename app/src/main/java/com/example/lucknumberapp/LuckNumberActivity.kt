package com.example.lucknumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

class LuckNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luck_number)


        val luckyTxt: TextView = findViewById(R.id.luckyNum)
        val shareBtn: Button = findViewById(R.id.shareBtn)

        var user_name = receiveUsername()


        var randomNumber = generateRandomNum()
        luckyTxt.setText(""+randomNumber)

        shareBtn.setOnClickListener(){
            shareData(user_name, randomNumber)
        }

    }

    fun receiveUsername(): String {
        var bundle: Bundle? = getIntent().extras
        var userName = bundle?.getString("name").toString()
        return userName
    }

    // Random number generator
    fun generateRandomNum(): Int{
        val random = Random.nextInt(1000)
        return random
    }

    // Sharing the username and random number
    fun shareData(username: String, num: Int){

        // Implicit Intent
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today!")
        i.putExtra(Intent.EXTRA_TEXT, "Lucky number is $num")
        startActivity(i)

    }

}