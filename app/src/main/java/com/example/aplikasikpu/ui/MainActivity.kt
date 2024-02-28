package com.example.aplikasikpu.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aplikasikpu.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnEntyData=findViewById<Button>(R.id.btn_entry);
        val btnLihatData=findViewById<Button>(R.id.btn_lihat_data);
        val btnCekLokasi=findViewById<Button>(R.id.btn_location);
        val btnInformasi=findViewById<Button>(R.id.btn_information);

        btnEntyData.setOnClickListener {
            val intent=Intent(this, EntryFormActivity::class.java)
            startActivity(intent)
        }

        btnLihatData.setOnClickListener {
            val intent=Intent(this, ListDataActivity::class.java)
            startActivity(intent)
        }

        btnCekLokasi.setOnClickListener {
            val intent=Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }
}