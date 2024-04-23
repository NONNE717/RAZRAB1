package com.example.ladahelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        val srvkz:TextView=findViewById(R.id.Servkzn)
        val srvms:TextView=findViewById(R.id.Servmsk)
        srvkz.setOnClickListener {
            val  intent = Intent(this,ServKZNActivity::class.java)
            startActivity(intent)
        }
        srvms.setOnClickListener {
            val  intent = Intent(this,ServMSKActivity::class.java)
            startActivity(intent)
        }

    }
}