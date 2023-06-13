package com.example.wenjiezhou_comp304sec002_lab02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetachedActivity : AppCompatActivity() {

    private lateinit var header: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detached)

        header = findViewById(R.id.textViewDetached)
        recyclerView = findViewById(R.id.recyclerViewDetached)
        button = findViewById(R.id.buttonDetached)

        adapter = Adapter(this, getList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener{
            val type = "Detached Home"
            val selectedHouses = adapter.getSelectedHouses()

            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putExtra("type", type)
            intent.putStringArrayListExtra("selectedHouses", ArrayList(selectedHouses))
            startActivity(intent)
        }
    }

    private fun getList(): List<House> {
        return listOf(
            House(false, "41 CALLENDER ST, Toronto ON  $5795", R.drawable.detached1),
            House(false, "73 GLENDORA AVE, Toronto ON  $4500", R.drawable.detached2),
            House(false, "51 ROSEWELL AVE, Toronto ON  $6250", R.drawable.detached3),
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_house, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            R.id.menu_apartment ->
            {
                moveToApartmentActivity()
                true
            }

            R.id.menu_detached ->
            {
                moveToDetachedActivity()
                true
            }

            R.id.menu_semi_detached ->
            {
                moveToSemiDetachedActivity()
                true
            }

            R.id.menu_condo ->
            {
                moveToCondoActivity()
                true
            }

            R.id.menu_townhouse ->
            {
                moveToTownhouseActivity()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveToApartmentActivity()
    {
        val intent = Intent(this, ApartmentActivity::class.java)
        startActivity(intent)
    }

    private fun moveToDetachedActivity()
    {
        val intent = Intent(this, DetachedActivity::class.java)
        startActivity(intent)
    }

    private fun moveToSemiDetachedActivity()
    {
        val intent = Intent(this, SemiDetachedActivity::class.java)
        startActivity(intent)
    }

    private fun moveToCondoActivity()
    {
        val intent = Intent(this, CondoActivity::class.java)
        startActivity(intent)
    }

    private fun moveToTownhouseActivity()
    {
        val intent = Intent(this, TownhouseActivity::class.java)
        startActivity(intent)
    }
}