package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val btnGoConstell = findViewById<Button>(R.id.btnGoResultConstell)
        var intent : Intent
        val datePicker = findViewById<DatePicker>(R.id.date_picker_actions)
        val txtConstell = findViewById<TextView>(R.id.txtConstell)
        txtConstell.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)

        btnGoConstell.setOnClickListener {
            intent = Intent(this@ConstellationActivity, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result",ArrayList(getLottoNumbersFromHash(makeConstellationString(datePicker.month, datePicker.dayOfMonth))))
            intent.putExtra("constellation",makeConstellationString(datePicker.month, datePicker.dayOfMonth))
            startActivity(intent)
        }
    }

    private fun makeConstellationString(month: Int, day: Int): String {
        val target = "${month+1}${String.format("%02d",day)}".toInt()

        when (target){
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1224 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타별자리"
        }
    }

    fun getLottoNumbersFromHash(str: String): MutableList<Int>{
        // 정수 list todtjd
        val list = mutableListOf<Int>()
        // list에 정수 저장
        for (number in 1..45){
            list.add(number)
        }

        val targetString = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS", Locale.KOREA).format(Date()) + str

        // list 섞기. SEED 값으로 이름의 hash 코드 사용
        list.shuffle(Random(targetString.hashCode().toLong())) // 같은 seed 사용하면 항상 같은 sequence
        // 앞에서부터 6개 반환
        return list.subList(0, 6)
    }
}