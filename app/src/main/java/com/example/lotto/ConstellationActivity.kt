package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        Toast.makeText(this,"Constellation Activity", Toast.LENGTH_LONG).show()

        val btnGoResult = findViewById<Button>(R.id.btnGoResult)

        btnGoResult.setOnClickListener {
            startActivity(Intent(this,ResultActivity::class.java))
        }

    }
}