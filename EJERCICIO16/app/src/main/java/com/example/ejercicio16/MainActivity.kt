package com.example.ejercicio16

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonOk : Button=findViewById(R.id.buttonIniciar)
        val getResult = registerForActivityResult( ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val provincia = result.data?.getStringExtra("provincia key")
                findViewById<TextView>(R.id.tvResultado).text=provincia ;
                Toast.makeText(this, "Valor recibido: $provincia", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Operación cancelada", Toast.LENGTH_SHORT).show()
            }
        }
        buttonOk.setOnClickListener {

            // Lanzar la Activity secundaria
            val intent = Intent(this, MainActivity2::class.java)
            getResult.launch(intent)
        }

    }
}

