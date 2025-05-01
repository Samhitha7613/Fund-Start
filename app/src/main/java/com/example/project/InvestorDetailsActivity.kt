package com.example.project

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InvestorDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investor_details)

        // Get investor name from the intent
        val investorName = intent.getStringExtra("INVESTOR_NAME")

        // Set investor name in the TextView
        val investorNameTextView = findViewById<TextView>(R.id.investorName)
        investorNameTextView.text = investorName
    }
}
