package com.example.midtermbtueasy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.davaleba1.R

class SecondActivity : AppCompatActivity() {

    private lateinit var emailTextView: TextView
    private lateinit var messageTextView: TextView
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        emailTextView = findViewById(R.id.emailTextView)
        messageTextView = findViewById(R.id.messageTextView)
        clearButton = findViewById(R.id.clearButton)


        val email = intent.getStringExtra("EMAIL")
        val message = intent.getStringExtra("MESSAGE")

        emailTextView.text = email
        messageTextView.text = message

        clearButton.setOnClickListener {
            finish() 
        }
    }
}
