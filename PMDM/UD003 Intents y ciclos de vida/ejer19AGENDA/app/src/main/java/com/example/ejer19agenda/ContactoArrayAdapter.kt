package com.example.ejer19agenda

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import java.util.Objects

class ContactoArrayAdapter (
    context: Context?,
    resource: Int,
    objects: List<Contacto>?
) : ArrayAdapter<Contacto>(context!!,resource,objects!!){
    val view: View = convertView ?: LayoutInflater.from(this.context)
        .inflate(R.layout.fila_contacto, parent, false)


    val name = view.findViewById(R.id.txtNombre) as TextView
    val telefono = view.findViewById(R.id.txtTelefono) as TextView
    val img = view.findViewById(R.id.imgIconoContacto) as ImageView

}