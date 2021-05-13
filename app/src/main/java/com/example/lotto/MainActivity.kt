package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this,"Main Activity",Toast.LENGTH_LONG).show()

        val cardviewResult = findViewById<CardView>(R.id.cardviewResult)
        val cardviewConstellation = findViewById<CardView>(R.id.cardviewConstellation)
        val cardviewName = findViewById<CardView>(R.id.cardviewName)

        cardviewResult.setOnClickListener{
            startActivity(Intent(this,ResultActivity::class.java))
        }
        cardviewConstellation.setOnClickListener{
            startActivity(Intent(this,ConstellationActivity::class.java))
        }
        cardviewName.setOnClickListener{
            startActivity(Intent(this,NameActivity::class.java))
        }



    }
}