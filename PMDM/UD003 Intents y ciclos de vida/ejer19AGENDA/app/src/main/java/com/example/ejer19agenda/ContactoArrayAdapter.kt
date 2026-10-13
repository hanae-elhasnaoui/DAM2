package com.example.ejer19agenda

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ContactoArrayAdapter(
    context: Context,
    resource: Int,
    objects: List<Contacto>
) : ArrayAdapter<Contacto>(context, resource, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(this.context)
            .inflate(R.layout.fila_contacto, parent, false)

        val name: TextView = view.findViewById(R.id.txtNombre)
        val telefono: TextView = view.findViewById(R.id.txtTelefono)
        val img: ImageView = view.findViewById(R.id.imgIconoContacto)

        getItem(position)?.let {
            name.text = it.nombre
            telefono.text = it.tel
            img.setImageResource(it.icon)
        }

        return view
    }
}