package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList



class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        Toast.makeText(this,"Constellation Activity", Toast.LENGTH_LONG).show()

        val btnGoResult = findViewById<Button>(R.id.btnGoResultConstell)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val txtConstell = findViewById<TextView>(R.id.txtConstell)
        txtConstell.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)

        btnGoResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result",
                    ArrayList(getShuffledLottoNumbersFromHash(txtConstell.text.toString(),datePicker.month,datePicker.dayOfMonth)))
            intent.putExtra("constellation", makeConstellationString(datePicker.month,datePicker.dayOfMonth))
            startActivity(intent)
        }
        val calendar = Calendar.getInstance()

        datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),
                object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener{
                    override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
                        TODO("Not yet implemented")
                    }

                    override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                        txtConstell.text = makeConstellationString(datePicker.month,datePicker.dayOfMonth)
                    }
                }
        )
    }
    fun getShuffledLottoNumbersFromHash(str: String, month: Int, dayOfMonth: Int): MutableList<Int>{
        // ?????? list todtjd
        val list = mutableListOf<Int>()
        // list??? ?????? ??????
        for (number in 1..45){
            list.add(number)
        }

        //   val targetString = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS", Locale.KOREA).format(Date()) + str
        //val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + str
        val target = "${month + 1}${String.format("%02d",dayOfMonth)}".toString() + str
        // list ??????. SEED ????????? ????????? hash ?????? ??????
        list.shuffle(Random(target.hashCode().toLong())) // ?????? seed ???????????? ?????? ?????? sequence
        // ??????????????? 6??? ??????
        return list.subList(0, 6)
    }
    private fun makeConstellationString(month: Int, dayOfMonth: Int): CharSequence? {
        val target = "${month + 1}${String.format("%02d",dayOfMonth)}".toInt()

        when (target){
            in 101..119 -> return "????????????"
            in 120..218 -> return "????????????"
            in 219..320 -> return "???????????????"
            in 321..419 -> return "?????????"
            in 420..520 -> return "????????????"
            in 521..621 -> return "???????????????"
            in 622..722 -> return "?????????"
            in 723..822 -> return "????????????"
            in 823..923 -> return "????????????"
            in 924..1022 -> return "????????????"
            in 1023..1122 -> return "????????????"
            in 1123..1224 -> return "????????????"
            in 1225..1231 -> return "????????????"
            else -> return "???????????????"
        }
    }
}


