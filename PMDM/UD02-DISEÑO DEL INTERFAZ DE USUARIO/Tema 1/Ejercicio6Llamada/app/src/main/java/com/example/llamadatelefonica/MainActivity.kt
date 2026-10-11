package com.example.llamadatelefonica

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
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

        val btnLlamar = findViewById<ImageButton>(R.id.btn_llamar)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val tvMensaje = findViewById<TextView>(R.id.tv_mesage)
        var llamando = false

        btnLlamar.setOnClickListener {
            if (!llamando){
                tvMensaje.text="Llamando a walter white"
                btnLlamar.setImageResource(R.drawable.callstarted)
                imageView.setImageResource(R.drawable.walterwhitecalling)
                llamando = true
            }else{
                tvMensaje.text = " Pulsa para llamar walter white"
                btnLlamar.setImageResource(R.drawable.calltel)
                imageView.setImageResource(R.drawable.walterwhite)

                llamando = false
            }

        }
    }
}