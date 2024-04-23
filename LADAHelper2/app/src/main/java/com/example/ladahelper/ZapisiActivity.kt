package com.example.ladahelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ZapisiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zapisi)
        val textzap:EditText=findViewById(R.id.enterZapis)
        val butzap:Button=findViewById(R.id.enterButZpis)
        val listzap=findViewById<ListView>(R.id.zappis)

        val todos:MutableList<String> = mutableListOf()
        val adapter =ArrayAdapter(this,android.R.layout.simple_list_item_1,todos)
        listzap.adapter =adapter


        butzap.setOnClickListener {
            val textzappis=textzap.text.toString().trim()
            val zap = Zapisi(textzappis)
            val db =DataBaseZapisi(this,null)
            db.addzap(zap)
            Toast.makeText(this,"Добавлено", Toast.LENGTH_LONG).show()
            adapter.insert(textzappis,0)
        }
    }
}