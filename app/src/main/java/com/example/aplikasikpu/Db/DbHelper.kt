package com.example.aplikasikpu.Db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.aplikasikpu.Data.Volter

class DbHelper(context: Context) : SQLiteOpenHelper(context,"aplikasikpu", null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE IF NOT EXISTS datakpu(ID INTEGER PRIMARY KEY autoincrement, NIK TEXT, NAMA TEXT,ALAMAT TEXT,GENDER TEXT)"
        if (db != null) {
            db.execSQL(createTableQuery)
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }


    fun insertData(NIK: String, NAMA:String, ALAMAT: String, GENDER: String){
        val table= "datakpu"
        val db = writableDatabase
        val values = ContentValues().apply {
            put("NIK",NIK)
            put("NAMA",NAMA)
            put("ALAMAT",ALAMAT)
            put("GENDER",GENDER)
        }
        db.insert(table,null, values)
        db.close()
    }

    fun getAll():ArrayList<Volter>{
        val arraylistvoter=ArrayList<Volter>();
        arraylistvoter.clear()
        val db = readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM datakpu", null)
        if (cursor.moveToNext()) {
            do {
                val voter=Volter()
                val id = cursor.getString(0)
                val nik = cursor.getString(1)
                val nama = cursor.getString(2)
                val alamat = cursor.getString(3)
                val gender = cursor.getString(4)
                voter.ID=id.toInt()
                voter.NIK=nik
                voter.NAMA=nama
                voter.ALAMAT=alamat
                voter.GENDER=gender
                arraylistvoter.add(voter)

            }while (cursor.moveToNext())
        }
        return arraylistvoter
    }


    fun UpdateData(ID:Int, NIK: String,NAMA: String,ALAMAT: String,GENDER: String){
        val database = this.writableDatabase
        val values = ContentValues()
        values.put("NIK", NIK)
        values.put("NAMA",NAMA)
        values.put("ALAMAT",ALAMAT)
        values.put("GENDER",GENDER)
        database.update("datakpu", values, "ID=?", arrayOf(ID.toString()))
        database.close()
    }

    fun DeleteData(ID:Int){
        val db = this.writableDatabase
        val QUERY = "DELETE FROM datakpu WHERE ID = ?"
        db.execSQL(QUERY, arrayOf(ID.toString()))
        db.close()
    }
}