package com.example.wenjiezhou_comp304sec002_lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val selectedHouses = intent.getStringArrayListExtra("selectedHouses")?: emptyList<String>()

        val type = findViewById<TextView>(R.id.textViewType)
        val radio1 = findViewById<RadioButton>(R.id.radioButtonList1)
        val radio2 = findViewById<RadioButton>(R.id.radioButtonList2)
        val radio3 = findViewById<RadioButton>(R.id.radioButtonList3)

        type.text = intent.getStringExtra("type")
        radio1.text = selectedHouses.getOrNull(0) ?: ""
        radio2.text = selectedHouses.getOrNull(1) ?: ""
        radio3.text = selectedHouses.getOrNull(2) ?: ""

        val button = findViewById<Button>(R.id.buttonNext)
        button.setOnClickListener{
            if (radio1.isChecked || radio2.isChecked || radio3.isChecked)
            {
                val intent = Intent(this, PaymentActivity::class.java)
                startActivity(intent)
            }
        }
    }
}