package com.example.ejercicioguiado

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var intentos=3
        var numeroObjetivo=(1..100).random()

        val etNumero=findViewById<EditText>(R.id.etNumero)
        val btnComprobar=findViewById<Button>(R.id.btnComprobar)
        val tvMensaje=findViewById<TextView>(R.id.tvMensaje)

        btnComprobar.setOnClickListener {
            val texto=etNumero.text.toString()
            if(texto.isEmpty()){
                Toast.makeText(this, "por favor introduce un numero", Toast.LENGTH_SHORT).show()
            }else{
                val numeroUsuario=texto.toInt()
                intentos--

                if (numeroUsuario==numeroObjetivo){
                    tvMensaje.text="¡Felicidades! Has acertado. El número era $numeroObjetivo.\n¡Se ha iniciado una nueva partida!"
                    numeroObjetivo=(1..100).random()
                    intentos=3
                }else if (intentos==0){
                    tvMensaje.text = "¡Perdiste! Se agotaron los intentos. El número era $numeroObjetivo.\n¡Se ha iniciado una nueva partida!"
                    numeroObjetivo = (1..100).random()
                    intentos = 3
                }else{
                    if (numeroUsuario < numeroObjetivo){
                        tvMensaje.text = "El número secreto es MAYOR.\nTe quedan $intentos intentos. "
                    }else{
                        tvMensaje.text = "El número secreto es MENOR.\nTe quedan $intentos intentos."
                    }
                }

            }

            etNumero.text.clear()

        }




    }
}