package com.example.aplikasikpu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.aplikasikpu.Db.DbHelper
import com.example.aplikasikpu.R

class EntryFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_form)
        getSupportActionBar()?.setTitle("Entry Data")

        val btnSave=findViewById<Button>(R.id.btn_save);
        val edtNIK=findViewById<EditText>(R.id.edt_nik);
        val edtNAMA=findViewById<EditText>(R.id.edt_name);
        val edtALAMAT=findViewById<EditText>(R.id.edt_address);
        val edtGENDER=findViewById<EditText>(R.id.edt_sex);
        val helper=DbHelper(this)
        btnSave.setOnClickListener {
           helper.insertData(edtNIK.getText().toString(),edtNAMA.getText().toString(),edtALAMAT.getText().toString(),edtGENDER.getText().toString())
           val intent=Intent(this,MainActivity::class.java);
            startActivity(intent)
            finish()
        }
    }
}