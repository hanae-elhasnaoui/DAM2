package com.example.ejer19agenda

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var lvContactos: ListView

    private val listaContactos = ArrayList<Contacto>()

    private lateinit var adaptador: ContactoArrayAdapter

    private val codigoPermiso = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.title ="Agenda"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lvContactos = findViewById(R.id.lvContactos)

        adaptador = ContactoArrayAdapter(
            this,
            R.layout.fila_contacto,
            listaContactos
        )

        lvContactos.adapter = adaptador


        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            cargarContactos()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                codigoPermiso
            )
        }

        lvContactos.setOnItemClickListener {  parent, view, position, id ->

            val contacto = listaContactos[position]

            val intent = Intent(
                Intent.ACTION_DIAL,
                "tel:${contacto.tel}".toUri()
            )

            startActivity(intent)
        }


    }

    private fun cargarContactos() {

        listaContactos.clear()

        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI

        val columnas = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )

        contentResolver.query(
            uri,
            columnas,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )?.use { cursor ->

            val indiceNombre = cursor.getColumnIndexOrThrow(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            )

            val indiceTelefono = cursor.getColumnIndexOrThrow(
                ContactsContract.CommonDataKinds.Phone.NUMBER
            )

            while (cursor.moveToNext()) {

                val nombre = cursor.getString(indiceNombre) ?: ""
                val telefono = cursor.getString(indiceTelefono) ?: ""

                val contacto = Contacto(
                    nombre,
                    telefono,
                    android.R.drawable.ic_menu_call
                )

                listaContactos.add(contacto)
            }
        }

        adaptador.notifyDataSetChanged()

        Toast.makeText(
            this,
            "Contactos cargados: ${listaContactos.size}",
            Toast.LENGTH_LONG
        ).show()
    }


}