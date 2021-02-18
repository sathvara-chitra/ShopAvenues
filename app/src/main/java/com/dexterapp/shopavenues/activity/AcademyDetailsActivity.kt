package com.dexterapp.shopavenues.activity

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dexterapp.shopavenues.HomeActivity
import com.dexterapp.shopavenues.R
import java.util.*

class AcademyDetailsActivity : AppCompatActivity() {
    private var btnBack: ImageView? = null
    private var txtCalendar: TextView? = null
    private var btnBook: LinearLayout? = null
    var curDate = 0
    var Year = 0
    var Month = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_academy_details)
        init()
        onClick()

    }


    private fun init() {
        btnBack = findViewById(R.id.btnBack) as ImageView
        txtCalendar = findViewById(R.id.txtCalendar) as TextView
        btnBook = findViewById(R.id.btnBook) as LinearLayout


    }

    private fun onClick() {
        btnBack!!.setOnClickListener {
            finish()
        }
        txtCalendar!!.setOnClickListener {
            showCalendarDialog(this)
        }
        btnBook!!.setOnClickListener {
            showDialog(this)
        }
    }

    fun showDialog(activity: Activity?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.payment_alert_dialog)
        val btnPay = dialog.findViewById(R.id.btnPay) as LinearLayout
        btnPay.setOnClickListener {
            val mainIntent = Intent(activity, HomeActivity::class.java)
            startActivity(mainIntent)
            finish()
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showCalendarDialog(activity: Activity?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.calendar_alert_dialog)
        val calendarView = dialog.findViewById(R.id.calendarView) as CalendarView
        val btnCancel = dialog.findViewById(R.id.btnCancel) as LinearLayout
        val btnDone = dialog.findViewById(R.id.btnDone) as LinearLayout
        val c = Calendar.getInstance()
        Year = c[Calendar.YEAR]
        Month = c[Calendar.MONTH]
        curDate = c[Calendar.DAY_OF_MONTH]

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            curDate = dayOfMonth
            Year = year
            Month = month+1

        }
        btnCancel.setOnClickListener {

            dialog.dismiss()
        }
        btnDone.setOnClickListener {
            Log.e("date", "$curDate/$Month/$Year")
            txtCalendar!!.setText("$curDate/$Month/$Year")
            dialog.dismiss()
        }

        dialog.show()
    }
}