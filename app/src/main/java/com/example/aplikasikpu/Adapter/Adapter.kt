package com.example.aplikasikpu.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasikpu.Data.Volter
import com.example.aplikasikpu.Db.DbHelper
import com.example.aplikasikpu.R
import com.example.aplikasikpu.ui.DetailActivity
import com.example.aplikasikpu.ui.UpdateActivity

class Adapter(val list:ArrayList<Volter>, val context: Context): RecyclerView.Adapter<Adapter.MyHolder>() {

    class MyHolder(itemview: View):  RecyclerView.ViewHolder(itemview){
        val txtNik: TextView =itemview.findViewById(R.id.tv_item_nik)
        val txtNama: TextView =itemview.findViewById(R.id.tv_item_nama)
        val btnUpdate: Button =itemview.findViewById(R.id.btn_update)
        val btnDelete: Button =itemview.findViewById(R.id.btn_delete)
        val cardview=itemview.findViewById<CardView>(R.id.cv_item_voter)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyHolder {
        val item= LayoutInflater.from(parent.context).inflate(R.layout.item_voter, parent,false)
        return Adapter.MyHolder(item)
    }



    override fun onBindViewHolder(holder: Adapter.MyHolder, position: Int) {
        holder.txtNik.setText(list.get(position).NIK)
        holder.txtNama.setText(list.get(position).NAMA)
        holder.cardview.setOnClickListener {
            val intent=Intent(context,DetailActivity::class.java)
            intent.putExtra("ID",list.get(position).ID.toString())
            intent.putExtra("NIK",list.get(position).NIK.toString())
            intent.putExtra("NAMA",list.get(position).NAMA.toString())
            intent.putExtra("ALAMAT",list.get(position).ALAMAT.toString())
            intent.putExtra("GENDER",list.get(position).GENDER.toString())
            context.startActivity(intent)
            (context as Activity).finish()
        }

        holder.btnUpdate.setOnClickListener {
            val intent=Intent(context,UpdateActivity::class.java)
            intent.putExtra("ID",list.get(position).ID.toString())
            intent.putExtra("NIK",list.get(position).NIK.toString())
            intent.putExtra("NAMA",list.get(position).NAMA.toString())
            intent.putExtra("ALAMAT",list.get(position).ALAMAT.toString())
            intent.putExtra("GENDER",list.get(position).GENDER.toString())
           context.startActivity(intent)
            (context as Activity).finish()
        }
        holder.btnDelete.setOnClickListener {
            val helper=DbHelper(context)
            helper.DeleteData(list.get(position).ID)
            val intent=Intent(context,UpdateActivity::class.java)
            Toast.makeText(context,"Data Berhasil Dihapus",Toast.LENGTH_SHORT).show()
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }

    override fun getItemCount(): Int {
        return list.size

    }
}