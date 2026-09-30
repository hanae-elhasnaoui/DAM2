package com.example.ejer16

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    val getResult =
        this.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            // Este bloque de código se activa automáticamente al regresar de MainActivity2
            if (result.resultCode == RESULT_OK) {
                // Recuperamos el String de la provincia enviado desde la segunda pantalla
                val provinciaElegida = result.data?.getStringExtra("PROVINCIA_SELECCIONADA") ?: ""

                // Buscamos el TextView usando el ID de tu XML y cambiamos su texto en caliente
                val tvResultado = findViewById<TextView>(R.id.tvResultado)
                tvResultado.text = "Se ha\nseleccionado:\n$provinciaElegida"
            } else {
                Toast.makeText(this, "Operacion cancelada", Toast.LENGTH_SHORT).show()
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSeleccionar = findViewById<Button>(R.id.buttonIniciar)

        btnSeleccionar.setOnClickListener {

            val intent = Intent (this, MainActivity2::class.java)
            getResult.launch(intent)
        }
    }


}