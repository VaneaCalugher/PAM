package com.malkinfo.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var selectDate:TextView
    private lateinit var calsiBtn:Button
    private lateinit var showAge:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**set find Id*/
        selectDate = findViewById(R.id.selectDate)
        calsiBtn = findViewById(R.id.calsi)
        showAge = findViewById(R.id.showAge)

    }

    fun selectDate(view: View) {
        var c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)
        /**set CalendarDialog*/
        val calendarDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                cDay = dayOfMonth
                cMonth = month
                cYear = year
                calsiBtn.visibility = View.VISIBLE
                textMassge("You select Date :$cDay/${cMonth+1}/$cYear")
                calsiBtn.setOnClickListener {
                    val currentYear = Calendar.getInstance()
                        .get(Calendar.YEAR)
                   if (cYear>currentYear){
                       textMassge("Date is not valid")
                   }
                    else{
                       val age = currentYear - cYear
                       showAge.visibility = View.VISIBLE
                       showAge.text = "Your Age is $age year"
                       textMassge("Your Age is $age year")
                   }
                }
                selectDate.text = "You select Date :$cDay/${cMonth+1}/$cYear"
            },cYear,cMonth,cDay)
        calendarDialog.show()

    }

    private fun textMassge(s: String) {
           Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }
    /**ok now run it*/


}