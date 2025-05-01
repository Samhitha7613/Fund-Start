package com.example.project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class LoanCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_calculator)

        // UI elements
        val loanAmountInput = findViewById<EditText>(R.id.loanAmount)
        val interestRateInput = findViewById<EditText>(R.id.interestRate)
        val loanTermInput = findViewById<EditText>(R.id.loanTerm)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultText = findViewById<TextView>(R.id.monthlyPaymentResult)

        calculateButton.setOnClickListener {
            val loanAmount = loanAmountInput.text.toString().toDoubleOrNull()
            val interestRate = interestRateInput.text.toString().toDoubleOrNull()
            val loanTermYears = loanTermInput.text.toString().toIntOrNull()

            if (loanAmount != null && interestRate != null && loanTermYears != null &&
                loanAmount > 0 && interestRate > 0 && loanTermYears > 0) {

                val monthlyRate = interestRate / 100 / 12
                val months = loanTermYears * 12

                val emi = (loanAmount * monthlyRate) /
                        (1 - Math.pow(1 + monthlyRate, -months.toDouble()))

                val formattedEmi = DecimalFormat("₹#,##0.00").format(emi)
                resultText.text = "Monthly Payment: $formattedEmi"
            } else {
                Toast.makeText(this, "Please enter valid numbers in all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
