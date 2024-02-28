package com.example.aplikasikpu.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasikpu.Adapter.Adapter
import com.example.aplikasikpu.Db.DbHelper
import com.example.aplikasikpu.R

class ListDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data)
        val rview=findViewById<RecyclerView>(R.id.rview)
        val helper=DbHelper(this)
        val dataGetAll=helper.getAll()
        getSupportActionBar()?.setTitle("List Data")
        val layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        rview.layoutManager = layoutManager
        val adapter = Adapter(dataGetAll,this)
        rview.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}