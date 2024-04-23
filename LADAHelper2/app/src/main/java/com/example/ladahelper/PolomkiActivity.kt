package com.example.ladahelper

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.lang.UCharacter.VerticalOrientation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView

class PolomkiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_polomki)
        val patrub:TextView=findViewById(R.id.text_patrubk)
        val ddm : TextView=findViewById(R.id.ddm)

        patrub.setOnClickListener {
            val  intent = Intent(this,PatrrubkiActivity::class.java)
            startActivity(intent)
        }
        ddm.setOnClickListener {
            val  intent = Intent(this,DdmActivity::class.java)
            startActivity(intent)
        }
    }
}