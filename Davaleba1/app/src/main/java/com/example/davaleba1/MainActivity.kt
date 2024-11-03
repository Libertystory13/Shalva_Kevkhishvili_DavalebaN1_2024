package com.example.midtermbtueasy

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.davaleba1.R

class MainActivity : AppCompatActivity() {

    private lateinit var iconImage: ImageView
    private lateinit var emailEditText: EditText
    private lateinit var messageEditText: EditText
    private lateinit var sendMessageButton: Button
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        iconImage = findViewById(R.id.iconImage)
        emailEditText = findViewById(R.id.emailEditText)
        messageEditText = findViewById(R.id.messageEditText)
        sendMessageButton = findViewById(R.id.sendMessageButton)
        clearButton = findViewById(R.id.clearButton)


        iconImage.setImageResource(R.drawable.ic_message)

        messageEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && s.length > 250) {
                    messageEditText.error = "Maximum 250 characters allowed"
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        sendMessageButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val message = messageEditText.text.toString().trim()

            if (!isValidEmail(email)) {
                emailEditText.error = "Invalid email"
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (message.isEmpty()) {
                messageEditText.error = "Message cannot be empty"
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (message.length > 250) {
                messageEditText.error = "Message exceeds 250 characters"
                Toast.makeText(this, "Message should be under 250 characters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("EMAIL", email)
            intent.putExtra("MESSAGE", message)
            startActivity(intent)
        }

        clearButton.setOnClickListener {
            emailEditText.text.clear()
            messageEditText.text.clear()
            iconImage.setImageResource(R.drawable.ic_message)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
