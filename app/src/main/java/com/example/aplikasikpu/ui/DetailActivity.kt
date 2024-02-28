package com.example.aplikasikpu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.aplikasikpu.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val edtDetailNIK = findViewById<EditText>(R.id.edt_detail_nik)
        val edtDetailNAMA = findViewById<EditText>(R.id.edt_detail_name)
        val edtDetailALAMAT = findViewById<EditText>(R.id.edt_detail_address)
        val edtDetailGENDER = findViewById<EditText>(R.id.edt_detail_sex)

        edtDetailNIK.setText(intent.getStringExtra("NIK"))
        edtDetailNAMA.setText(intent.getStringExtra("NAMA"))
        edtDetailALAMAT.setText(intent.getStringExtra("ALAMAT"))
        edtDetailGENDER.setText(intent.getStringExtra("GENDER"))
        edtDetailNIK.setFocusable(false)
        edtDetailNAMA.setFocusable(false)
        edtDetailALAMAT.setFocusable(false)
        edtDetailGENDER.setFocusable(false)
    }
}