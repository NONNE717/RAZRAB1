package com.example.ladahelper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AutorizeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autorize)

        val LtoReg:TextView = findViewById(R.id.TOreg)
        val userLogin: EditText =findViewById(R.id.User_login_aut)
        val userPassword: EditText =findViewById(R.id.User_password_aut)
        val button: Button =findViewById(R.id.ButAut)

        LtoReg.setOnClickListener {
            val  intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener{
            val login=userLogin.text.toString().trim()
            val password=userPassword.text.toString().trim()
            if (login==""||password==""){
                Toast.makeText(this,"Заполните все поля!", Toast.LENGTH_LONG).show()
            }
            else{
                val db = DataBaseLink(this,null)
                val isAut = db.checkUs(login,password)
                if (isAut){
                    Toast.makeText(this,"Успешно", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()
                    val  intent = Intent(this,MenuActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Пользователь не найден", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}