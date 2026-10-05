package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Suppress("DEPRECATION")
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


        val camaraLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { resultado ->
                if (resultado.resultCode == RESULT_OK) {
                    val imagenBitmap = resultado.data?.extras?.get("data") as? Bitmap
                    // Buscamos el ImageView directamente y le asignamos la foto
                    findViewById<ImageView>(R.id.imgFoto).setImageBitmap(imagenBitmap)
                } else {
                    Toast.makeText(this, "Captura cancelada", Toast.LENGTH_SHORT).show()
                }
            }


        // 2. Configuramos el botón directamente buscando su ID al vuelo
        findViewById<Button>(R.id.btnCamara).setOnClickListener {
            val intentCamara = Intent(ACTION_IMAGE_CAPTURE)
            try {
                // Lanzamos la cámara directamente al grano
                camaraLauncher.launch(intentCamara)
            } catch (_: Exception) {
                // Si ocurre un error o no encuentra la app, entra aquí
                Toast.makeText(this, "No hay app de cámara disponible", Toast.LENGTH_SHORT).show()
            }
        }

    }

}