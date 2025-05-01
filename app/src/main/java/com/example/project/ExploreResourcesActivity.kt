package com.example.project
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExploreResourcesActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore_resources)

        val fundingGuide = findViewById<TextView>(R.id.fundingGuideText) // Update this ID if needed
        val legalCompliance = findViewById<TextView>(R.id.legalComplianceText) // Update this ID if needed
        val pitchDeckExamples = findViewById<TextView>(R.id.pitchDeckExamplesText) // Update this ID if needed
        val mentorshipNetworking = findViewById<TextView>(R.id.mentorshipNetworkingText) // Update this ID if needed
        val freeStartupTools = findViewById<TextView>(R.id.freeStartupToolsText) // Update this ID if needed

        fundingGuide.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://drive.google.com/file/d/1ULdlMIAvEF4uW3Uz5RbRO-7WNOaKu1Nx/view?usp=sharing")
            startActivity(intent)
        }
        legalCompliance.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://drive.google.com/file/d/1O5kxN6xZF3cyaH-WNngowz80kbWjP8qS/view?usp=sharing")
            startActivity(intent)
        }
        pitchDeckExamples.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://drive.google.com/file/d/1aE-TT13tdJvU2d4Ar1hr-Y5GDfe940Dn/view?usp=sharing")
            startActivity(intent)
        }
        mentorshipNetworking.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://drive.google.com/file/d/1TE3Ks23yqH8IfXWYFw5Luv4VO-7u8aoN/view?usp=sharing")
            startActivity(intent)
        }
        freeStartupTools.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://drive.google.com/file/d/14GOfl49Cs5VdeTMKmNY0bhSxaSJ_O6DZ/view?usp=sharing")
            startActivity(intent)

        }






    }
}
