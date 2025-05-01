package com.example.project

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ApplyFundingActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_funding)

        // Initialize Firebase
        db = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

        // Views
        val startupNameEditText = findViewById<EditText>(R.id.startupNameEditText)
        val fundingAmountEditText = findViewById<EditText>(R.id.fundingAmountEditText)
        val descriptionEditText = findViewById<EditText>(R.id.descriptionEditText)
        val pitchDeckLinkEditText = findViewById<EditText>(R.id.pitchDeckLinkEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = startupNameEditText.text.toString().trim()
            val amount = fundingAmountEditText.text.toString().trim()
            val description = descriptionEditText.text.toString().trim()
            val pitchLink = pitchDeckLinkEditText.text.toString().trim()
            val userEmail = auth.currentUser?.email ?: "Anonymous"

            if (name.isEmpty() || amount.isEmpty() || description.isEmpty() || pitchLink.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                val application = hashMapOf(
                    "startupName" to name,
                    "fundingAmount" to amount,
                    "description" to description,
                    "pitchDeckLink" to pitchLink,
                    "submittedBy" to userEmail,
                    "timestamp" to System.currentTimeMillis()
                )

                db.collection("funding_applications")
                    .add(application)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Application submitted successfully!", Toast.LENGTH_LONG).show()
                        // Clear form
                        startupNameEditText.text.clear()
                        fundingAmountEditText.text.clear()
                        descriptionEditText.text.clear()
                        pitchDeckLinkEditText.text.clear()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Failed to submit: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}
