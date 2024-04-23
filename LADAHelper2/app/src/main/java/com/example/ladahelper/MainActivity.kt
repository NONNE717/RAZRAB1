package com.example.ladahelper

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userLogin:EditText=findViewById(R.id.User_login)
        val userMail:EditText=findViewById(R.id.User_mail)
        val userPassword:EditText=findViewById(R.id.User_password)
        val button:Button=findViewById(R.id.ButReg)
        val Lautor: TextView = findViewById(R.id.ToAut)

        Lautor.setOnClickListener {
            val  intent = Intent(this,AutorizeActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener{
            val login=userLogin.text.toString().trim()
            val email=userMail.text.toString().trim()
            val password=userPassword.text.toString().trim()
            if (login==""||email==""||password==""){
                Toast.makeText(this,"Заполните все поля!",Toast.LENGTH_LONG).show()
            }
            else{
                val user=User(login, email,password)
                val db = DataBaseLink(this,null)
                db.addUser(user)
                Toast.makeText(this,"Успешно",Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userMail.text.clear()
                userPassword.text.clear()
            }
        }
    }
}