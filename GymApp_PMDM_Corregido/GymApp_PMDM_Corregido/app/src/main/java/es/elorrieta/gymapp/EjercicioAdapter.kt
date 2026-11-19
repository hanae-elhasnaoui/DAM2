package es.elorrieta.gymapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.elorrieta.gymapp.bd.entidades.Ejercicio

class EjercicioAdapter(
    private val datos: List<Pair<Ejercicio, Boolean>>,
    private val abrir: (Ejercicio) -> Unit
) : RecyclerView.Adapter<EjercicioAdapter.Fila>() {
    class Fila(v: View) : RecyclerView.ViewHolder(v) {
        val titulo: TextView = v.findViewById(R.id.tvTituloFila)
        val detalle: TextView = v.findViewById(R.id.tvDetalleFila)
        val boton: Button = v.findViewById(R.id.btnVideoFila)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Fila =
        Fila(LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false))
    override fun getItemCount() = datos.size
    override fun onBindViewHolder(holder: Fila, position: Int) {
        val (e, hecho) = datos[position]
        holder.titulo.text = "${e.orden}. ${e.nombre}"
        holder.detalle.text = "${e.tiempoEstimado} min · ${if (hecho) "✓" else "Pendiente"}"
        holder.boton.visibility = View.GONE
        holder.itemView.setOnClickListener { abrir(e) }
    }
}
