package com.example.ejemplo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class EmailDetailFragment : Fragment() {

    // Declaramos la variable del texto para poder usarla en el método del profesor
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_email_detail, container, false)

        // Inicializamos el TextView
        textView = view.findViewById(R.id.textViewEmail)

        return view
    }

    // PASO 6 DEL PROFESOR: El método exacto que viene en tu PDF
    fun mostrarEmail(email: String) {
        textView.text = email
    }
}
