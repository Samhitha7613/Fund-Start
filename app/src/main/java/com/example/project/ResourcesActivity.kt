package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResourcesActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resources)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        val ResourceList = listOf(
            "Startup Basics",
            "Funding",
            "Pitching & Business Planning",

        )

        val listView = findViewById<ListView>(R.id.ResourcesListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ResourceList)
        listView.adapter = adapter

        //intents

        listView.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(this, StartupBasicActivity::class.java))
                1 -> startActivity(Intent(this, FundingActivity::class.java))
                2 -> startActivity(Intent(this, PitchingBusinessActivity::class.java))
            }
        }
    }
}
