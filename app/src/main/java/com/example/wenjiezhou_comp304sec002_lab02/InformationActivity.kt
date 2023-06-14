package com.example.wenjiezhou_comp304sec002_lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.Context

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
        val confirmation = findViewById<TextView>(R.id.textViewConfirmation)

        when (paymentType) {
            1 -> method.hint = "Leave blank for cash payment"
            2 -> method.hint = "Credit Card No."
            3 -> method.hint = "Debit Card No."
        }

        val button = findViewById<Button>(R.id.buttonFinal)
        button.setOnClickListener{
            if(name.text.isEmpty())
            {
                confirmation.text = "Please input your name"
            }
            else if(address.text.isEmpty())
            {
                confirmation.text = "Please input your address"
            }
            else if(phone.text.isEmpty() || phone.text.length != 10)
            {
                confirmation.text = "Please input correct phone number"
            }
            else if(email.text.isEmpty() || !email.text.contains('@'))
            {
                confirmation.text = "Please input correct email address"
            }
            else if(paymentType != 1 && method.text.isEmpty() || paymentType != 1 && method.text.length != 16)
            {
                confirmation.text = "Please input correct card number"
            }
            else if(sport.text.isEmpty())
            {
                confirmation.text = "Please input your favorite sport"
            }
            else if(food.text.isEmpty())
            {
                confirmation.text = "Please input your favorite food"
            }
            else
            {
                name.text.clear()
                address.text.clear()
                phone.text.clear()
                email.text.clear()
                method.text.clear()
                sport.text.clear()
                food.text.clear()

                val sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()

                confirmation.text = "Thank you! We have received your information and will contact you shortly."
            }
        }
    }
}