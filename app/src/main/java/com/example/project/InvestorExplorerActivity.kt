package com.example.project
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class InvestorExplorerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_investor_explorer)

        // Card Views for each investor
        val investorCard1 = findViewById<CardView>(R.id.investorCard1)
        val investorCard2 = findViewById<CardView>(R.id.investorCard2)
        val investorCard3 = findViewById<CardView>(R.id.investorCard3)
        val investorCard4 = findViewById<CardView>(R.id.investorCard4)
        val investorCard5 = findViewById<CardView>(R.id.investorCard5)
        val investorCard6 = findViewById<CardView>(R.id.investorCard6)
        val investorCard7 = findViewById<CardView>(R.id.investorCard7)
        val investorCard8 = findViewById<CardView>(R.id.investorCard8)
        val investorCard9 = findViewById<CardView>(R.id.investorCard9)

        // Set click listeners for the cards to navigate to the details page
        investorCard1.setOnClickListener {
            navigateToInvestorDetails("Elon Musk")
        }

        investorCard2.setOnClickListener {
            navigateToInvestorDetails("Warren Buffet")
        }

        investorCard3.setOnClickListener {
            navigateToInvestorDetails("Jeff Bezos")
        }

        investorCard4.setOnClickListener {
            navigateToInvestorDetails("Richard Branson")
        }
        investorCard5.setOnClickListener {
            navigateToInvestorDetails("Mark Zuckerberg")
        }
        investorCard6.setOnClickListener {
            navigateToInvestorDetails("Larry Page")
        }
        investorCard7.setOnClickListener {
            navigateToInvestorDetails("Sergey Brin")
        }
        investorCard8.setOnClickListener {
            navigateToInvestorDetails("Tim Cook")
        }
        investorCard9.setOnClickListener {
            navigateToInvestorDetails("Satya Nadella")
            // Add more click listeners for other cards as needed
        }
    }

    // Function to navigate to InvestorDetailsActivity
    private fun navigateToInvestorDetails(investorName: String) {
        val intent = Intent(this, InvestorDetailsActivity::class.java)
        intent.putExtra("INVESTOR_NAME", investorName)
        startActivity(intent)
    }
}
