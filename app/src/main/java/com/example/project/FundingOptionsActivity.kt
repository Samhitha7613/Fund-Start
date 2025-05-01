package com.example.project

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class FundingOptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funding_options)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val fundingList = listOf(
            "Angel Investors",
            "Venture Capital",
            "Government Grants",
            "Crowdfunding",
            "Startup Loans",
            "Incubators & Accelerators"
        )

        val listView = findViewById<ListView>(R.id.fundingListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fundingList)
        listView.adapter = adapter

        //intents

        listView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(this, AngelInvestorsActivity::class.java)) // Angel Investors
                1 -> startActivity(Intent(this, VentureCapitalActivity::class.java)) // Venture Capital
                2 -> startActivity(Intent(this, GovernmentGrantsActivity::class.java)) // Government Grants
                3 -> startActivity(Intent(this, CrowdFundingActivity::class.java)) // Crowdfunding
                4 -> startActivity(Intent(this, StartupLoanActivity::class.java)) // Startup Loans
                5 -> startActivity(Intent(this, IncubatorAcceleratorActivity::class.java)) // Incubators & Accelerators
            }
        }

    }
}
