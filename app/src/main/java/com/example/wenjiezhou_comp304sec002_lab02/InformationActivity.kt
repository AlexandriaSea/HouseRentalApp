package com.example.wenjiezhou_comp304sec002_lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class InformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        val paymentType = intent.getIntExtra("paymentType", 0)

        val name = findViewById<EditText>(R.id.editTextName)
        val address = findViewById<EditText>(R.id.editTextAddress)
        val phone = findViewById<EditText>(R.id.editTextPhone)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val method = findViewById<EditText>(R.id.editTextPayment)
        val sport = findViewById<EditText>(R.id.editTextSport)
        val food = findViewById<EditText>(R.id.editTextFood)

        when (paymentType) {
            1 -> method.hint = "Leave blank for cash payment"
            2 -> method.hint = "Credit Card No."
            3 -> method.hint = "Debit Card No."
        }

        val button = findViewById<Button>(R.id.buttonFinal)
        button.setOnClickListener{
            name.text.clear()
            address.text.clear()
            phone.text.clear()
            email.text.clear()
            method.text.clear()
            sport.text.clear()
            food.text.clear()
        }
    }
}