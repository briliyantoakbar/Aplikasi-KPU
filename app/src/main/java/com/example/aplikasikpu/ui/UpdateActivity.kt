package com.example.aplikasikpu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.aplikasikpu.Db.DbHelper
import com.example.aplikasikpu.R

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        val edtUpdateNIK = findViewById<EditText>(R.id.edt_update_nik)
        val edtUpdateNAMA = findViewById<EditText>(R.id.edt_update_name)
        val edtUpdateALAMAT = findViewById<EditText>(R.id.edt_update_address)
        val edtUpdateGENDER = findViewById<EditText>(R.id.edt_update_sex)
        val btnUpdate = findViewById<Button>(R.id.btn_update)
        getSupportActionBar()?.setTitle("Update Data")

        var id = intent.getStringExtra("ID").toString()
        edtUpdateNIK.setText(intent.getStringExtra("NIK"))
        edtUpdateNAMA.setText(intent.getStringExtra("NAMA"))
        edtUpdateALAMAT.setText(intent.getStringExtra("ALAMAT"))
        edtUpdateGENDER.setText(intent.getStringExtra("GENDER"))
        btnUpdate.setOnClickListener {
            val helper = DbHelper(this)
            helper.UpdateData(
                id.toInt(),
                edtUpdateNIK.getText().toString(),
                edtUpdateNAMA.getText().toString(),
                edtUpdateALAMAT.getText().toString(),
                edtUpdateGENDER.getText().toString()
            )
            Toast.makeText(this, "Data Telah Di Update", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListDataActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}