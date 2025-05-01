package com.example.project

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Notification Setup
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "default_channel"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Default Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val intent = Intent(this, Notification::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("📢 Announcement from Admin")
            .setContentText("Hey users! New feature is live now 🚀")
            .setSmallIcon(R.drawable.img_4)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(1, notification)

        // Setup Toolbar & Drawer
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        ViewCompat.animate(toolbar).alpha(1f).setDuration(600).start()

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Handle drawer menu item clicks
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_funding -> startActivity(Intent(this, FundingOptionsActivity::class.java))
                R.id.nav_investors -> startActivity(Intent(this, InvestorExplorerActivity::class.java))
                R.id.nav_resources -> startActivity(Intent(this, ResourcesActivity::class.java))
                R.id.nav_events -> startActivity(Intent(this, Events::class.java))
            }
            drawerLayout.closeDrawers()
            true
        }

        // Settings Icon
        val settingsIcon = findViewById<ImageView>(R.id.icon_Settings)
        settingsIcon.setOnClickListener {
            val options = arrayOf("Profile", "Notifications", "Logout")
            AlertDialog.Builder(this)
                .setTitle("Settings")
                .setItems(options) { _, which ->
                    when (which) {
                        0 -> startActivity(Intent(this, profile::class.java))
                        1 -> startActivity(Intent(this, Notification::class.java))
                        2 -> {
                            Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
                            val logoutIntent = Intent(this, LoginActivity::class.java)
                            logoutIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(logoutIntent)
                            finish()
                        }
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
        }

        // CardView Clicks
        findViewById<CardView>(R.id.loanCalculatorCard).setOnClickListener {
            startActivity(Intent(this, LoanCalculatorActivity::class.java))
        }
        findViewById<CardView>(R.id.resourcesCard).setOnClickListener {
            startActivity(Intent(this, ExploreResourcesActivity::class.java))
        }
        findViewById<CardView>(R.id.fundingCard).setOnClickListener {
            startActivity(Intent(this, ApplyFundingActivity::class.java))
        }
        findViewById<CardView>(R.id.tipsCard).setOnClickListener {
            startActivity(Intent(this, PitchIdeaActivity::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) true
        else super.onOptionsItemSelected(item)
    }
}
