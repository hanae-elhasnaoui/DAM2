package com.example.ejercicioskotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var usernameInput: EditText
    lateinit var psdInput: EditText
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        usernameInput = findViewById(R.id.usr_name)
        psdInput = findViewById(R.id.usr_psd)
        loginBtn = findViewById(R.id.btn_login)
        val intentos = 3
        var contador = 0
        loginBtn.setOnClickListener {

            val usrname = usernameInput.text.toString()
            val psd = psdInput.text.toString()

            Log.i("Test credentials", "Username :$usrname and Passwoed : $psd")


             if (usrname == "admin" && psd == "1234") {
                 Toast.makeText(this, "Inicio correcto", Toast.LENGTH_SHORT).show()
                 contador=0
             } else {
                 contador++
                 if (contador < intentos) {
                     Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                 }else  {
                     loginBtn.isEnabled=false
                     Toast.makeText(this, "Te has bloqueado intenta otra vez", Toast.LENGTH_SHORT).show()

                 }
             }
            }



    }

}

