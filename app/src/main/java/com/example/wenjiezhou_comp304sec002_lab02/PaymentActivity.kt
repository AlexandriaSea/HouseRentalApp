package com.example.wenjiezhou_comp304sec002_lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val radioCash = findViewById<RadioButton>(R.id.radioButtonCash)
        val radioCredit = findViewById<RadioButton>(R.id.radioButtonCreditCard)
        val radioDebit = findViewById<RadioButton>(R.id.radioButtonDebitCard)
        val button = findViewById<Button>(R.id.buttonSubmit)

        button.setOnClickListener{
            var paymentType = 0
            if(radioCash.isChecked)
            {
                paymentType = 1
            }
            if(radioCredit.isChecked)
            {
                paymentType = 2
            }
            if (radioDebit.isChecked)
            {
                paymentType = 3
            }

            if(radioCash.isChecked || radioCredit.isChecked || radioDebit.isChecked)
            {
                val intent = Intent(this, InformationActivity::class.java)
                intent.putExtra("paymentType", paymentType)
                startActivity(intent)
            }
        }
    }
}