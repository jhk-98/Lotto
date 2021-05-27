package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import java.util.*

fun getRandomLottoNumber (): Int{
    return Random().nextInt(45)+1
}
fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    for(i in 1..6){
        var number = 0
        do{
            number = getRandomLottoNumber()
        }while(lottoNumbers.contains(number))
        lottoNumbers.add(number)
    }
    return lottoNumbers
}


fun getShuffledLottoNumbers () : MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    for(number in 1..45){
        lottoNumbers.add(number)
    }
    lottoNumbers.shuffle()

    return  lottoNumbers.subList(0, 6)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this,"Main Activity",Toast.LENGTH_LONG).show()

        val cardviewRandom = findViewById<CardView>(R.id.cardviewRandom)
        cardviewRandom.setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffledLottoNumbers()))
            startActivity(intent)
        }

        val cardviewConstellation = findViewById<CardView>(R.id.cardviewConstellation)
        cardviewConstellation.setOnClickListener{
            startActivity(Intent(this,ConstellationActivity::class.java))
        }

        val cardviewName = findViewById<CardView>(R.id.cardviewName)
        cardviewName.setOnClickListener{
            startActivity(Intent(this,NameActivity::class.java))
        }



    }
}