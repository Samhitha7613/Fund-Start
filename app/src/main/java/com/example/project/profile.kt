package com.example.project

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class profile : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        // Get views
        val nameEditText = findViewById<EditText>(R.id.editName)
        val emailEditText = findViewById<EditText>(R.id.editEmail)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val profileNameText = findViewById<TextView>(R.id.profileName)
        val profileEmailText = findViewById<TextView>(R.id.profileEmail)

        saveButton.setOnClickListener {

            val userName = nameEditText.text.toString()
            val userEmail = emailEditText.text.toString()
            profileNameText.text = "Name: $userName"
            profileEmailText.text = "Email: $userEmail"
        }
    }
}