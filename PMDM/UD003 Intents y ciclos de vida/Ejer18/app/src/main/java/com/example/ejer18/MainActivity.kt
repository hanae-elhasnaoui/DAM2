package com.example.ejer18

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etuRL=findViewById<EditText>(R.id.etUrl)
        val btnWeb=findViewById<Button>(R.id.btnWeb)
        val etLatitud = findViewById<EditText>(R.id.etLatitud)
        val etLongitud = findViewById<EditText>(R.id.etLongitud)
        val btnMapa = findViewById<Button>(R.id.btnMapa)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        btnWeb.setOnClickListener {

            val urlString=etuRL.text.toString().trim()
            if (!urlString.isEmpty()){
            try {
                val intentWeb = Intent(Intent.ACTION_VIEW , urlString.toUri())
                val choser = Intent.createChooser(intentWeb,getText(R.string.titulo_chooser))

                startActivity(choser)
            }catch (e: Exception) {
                Toast.makeText(this, "No hay aplicaciones disponibles para abrir este enlace", Toast.LENGTH_LONG).show()
            }
            }else{
                Toast.makeText(this, "introduce un site web por", Toast.LENGTH_SHORT).show()
            }

        }

        btnMapa.setOnClickListener {
            val lat = etLatitud.text.toString().trim()
            val lon = etLongitud.text.toString().trim()
            if (lat.isNotEmpty() && lon.isNotEmpty()) {
                    try {

                        val uriMapa = "geo:$lat,$lon?q=$lat,$lon(Destino)".toUri()

                        val intentMaap= Intent(Intent.ACTION_VIEW,uriMapa)
                        val chooserMapa= Intent.createChooser(intentMaap,"abrir mapa con : ")

                        startActivity(chooserMapa)

                    }catch (_: Exception){
                        Toast.makeText(this, "Error al intentar abrir el mapa", Toast.LENGTH_SHORT).show()

                    }

                }else{
                    Toast.makeText(this, "Por favor, introduce la latitud y la longitud", Toast.LENGTH_SHORT).show()
                }

            }

        btnEmail.setOnClickListener {
            val emailDestinatario=etEmail.text.toString().trim()

            if(!emailDestinatario.isEmpty()){
                try {
                    val intentEmail = Intent(Intent.ACTION_SENDTO).apply {
                        data = "mailto:".toUri() // Asegura que solo respondan aplicaciones de correo
                        putExtra(Intent.EXTRA_EMAIL, arrayOf(emailDestinatario)) // Pasa el array de destinatarios
                        putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo") // Opcional: Asunto
                        putExtra(Intent.EXTRA_TEXT, "Cuerpo del mensaje")    // Opcional: Mensaje
                    }

                    val chooser = Intent.createChooser(intentEmail, "Enviar correo con:")
                    startActivity(chooser)
                } catch (e: Exception) {
                    Toast.makeText(this, "No hay apps de correo válidas", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Por favor, escribe primero una dirección de correo", Toast.LENGTH_SHORT).show()
            }
        }



    }
}