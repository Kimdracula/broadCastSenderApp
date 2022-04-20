package com.example.broadcastsenderapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText:EditText = findViewById(R.id.textMessage)
        val button:Button = findViewById(R.id.buttonSend)
        button.setOnClickListener {
            val message = editText.text.toString()
            val broadcastMessage = Intent(KEY_INTENT_FILTER).apply {
                putExtra(KEY_MESSAGE,message)
                flags = Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
            }
            sendBroadcast(broadcastMessage)
        }
    }
}