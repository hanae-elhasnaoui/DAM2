package com.example.ejer19agenda

import android.content.Context
import android.widget.ArrayAdapter
import java.util.Objects

class ContactoArrayAdapter (
    context: Context?,
    resource: Int,
    objects: List<Contacto>?
) : ArrayAdapter<Contacto>(context!!,resource,objects!!){


}