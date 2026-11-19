package es.elorrieta.gymapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.elorrieta.gymapp.bd.entidades.Workout

class WorkoutAdapter(
    private val datos: List<Triple<Workout, Int, Int>>,
    private val abrir: (Workout) -> Unit,
    private val video: (Workout) -> Unit
) : RecyclerView.Adapter<WorkoutAdapter.Fila>() {
    class Fila(v: View) : RecyclerView.ViewHolder(v) {
        val titulo: TextView = v.findViewById(R.id.tvTituloFila)
        val detalle: TextView = v.findViewById(R.id.tvDetalleFila)
        val boton: Button = v.findViewById(R.id.btnVideoFila)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Fila =
        Fila(LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false))
    override fun getItemCount() = datos.size
    override fun onBindViewHolder(holder: Fila, position: Int) {
        val (w, total, hechos) = datos[position]
        holder.titulo.text = w.nombre
        holder.detalle.text = "Nivel ${w.nivel} · ${if (total == 0) 0 else hechos * 100 / total}%"
        holder.itemView.setOnClickListener { abrir(w) }
        holder.boton.visibility = if (w.video.isNullOrBlank()) View.GONE else View.VISIBLE
        holder.boton.setOnClickListener { video(w) }
    }
}
