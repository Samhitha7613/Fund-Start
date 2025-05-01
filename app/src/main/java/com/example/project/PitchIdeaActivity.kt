package com.example.project


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class PitchIdeaActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pitch_idea)

        db = FirebaseFirestore.getInstance()

        val ideaTitle = findViewById<EditText>(R.id.ideaTitleEditText)
        val ideaSummary = findViewById<EditText>(R.id.ideaSummaryEditText)
        val videoLink = findViewById<EditText>(R.id.videoLinkEditText)
        val contactEmail = findViewById<EditText>(R.id.contactEmailEditText)
        val submitButton = findViewById<Button>(R.id.submitPitchButton)

        submitButton.setOnClickListener {
            val title = ideaTitle.text.toString().trim()
            val summary = ideaSummary.text.toString().trim()
            val video = videoLink.text.toString().trim()
            val email = contactEmail.text.toString().trim()

            if (title.isEmpty() || summary.isEmpty() || video.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                val pitchData = hashMapOf(
                    "title" to title,
                    "summary" to summary,
                    "videoLink" to video,
                    "email" to email,
                    "timestamp" to System.currentTimeMillis()
                )

                db.collection("pitches")
                    .add(pitchData)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Pitch submitted successfully!", Toast.LENGTH_LONG).show()
                        ideaTitle.text.clear()
                        ideaSummary.text.clear()
                        videoLink.text.clear()
                        contactEmail.text.clear()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Failed: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}
