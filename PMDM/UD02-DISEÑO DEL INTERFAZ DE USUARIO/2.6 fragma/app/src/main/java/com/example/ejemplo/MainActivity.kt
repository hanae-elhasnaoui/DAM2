package com.example.ejemplo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Vinculamos el XML que contiene los dos fragmentos fijos uno al lado del otro
        setContentView(R.layout.activity_main)

        // Aplicamos los márgenes del sistema sobre el fragmento de la lista (fragmentList)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragmentList)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
