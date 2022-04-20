package com.example.broadcastsenderapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendMessage()
    }

    private fun sendMessage() {
        val editText: EditText = findViewById(R.id.textMessage)
        val button: Button = findViewById(R.id.buttonSend)
        button.setOnClickListener {
            val message = editText.text.toString()
            val broadcastMessage = Intent().apply {
                putExtra(KEY_MESSAGE, message)
                action = KEY_INTENT_FILTER
                @SuppressLint("WrongConstant")
                flags = FLAG_RECEIVER_INCLUDE_BACKGROUND
            }
            sendBroadcast(broadcastMessage)
        }
    }
}