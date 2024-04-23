package com.example.ladahelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseZapisi(val context: Context, val factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context,"ZPS",factory,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val quer="CREATE TABLE zapisi (id INT PRIMARY KEY, zapiss TEXT)"
        db!!.execSQL(quer)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS zapisi")
        onCreate(db)
    }
    fun addzap(zapis: Zapisi){
        val value = ContentValues()
        value.put("zapiss",zapis.zapText)
        val db=this.writableDatabase
        db.insert("zapisi",null,value)
        db.close()
    }
    fun getZapis(): Cursor? {
        val db = this.readableDatabase
        val result = db.rawQuery( "SELECT * FROM zapisi", null)
        return result
    }
}