package com.example.ejemplo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class EmailListFragment : Fragment() {

    private val emails = listOf("Correo 1", "Correo 2", "Correo 3")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_email_list, container, false)
        val listView = view.findViewById<ListView>(R.id.listViewEmails)

        // Esto es lo que hace que se muestren los correos en la pantalla
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, emails)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedEmail = emails[position]

            // PASO 5 DEL PROFESOR: Buscar el fragmento de al lado por su ID
            val detailFragment = parentFragmentManager.findFragmentById(R.id.fragmentDetail) as EmailDetailFragment

            // PASO 5 DEL PROFESOR: Llamar al método para mostrar el correo
            detailFragment.mostrarEmail(selectedEmail)
        }

        return view
    }
}
