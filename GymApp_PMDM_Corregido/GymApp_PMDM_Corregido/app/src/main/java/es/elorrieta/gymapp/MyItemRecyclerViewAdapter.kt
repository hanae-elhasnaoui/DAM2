package es.elorrieta.gymapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import es.elorrieta.gymapp.placeholder.PlaceholderContent.PlaceholderItem
import es.elorrieta.gymapp.databinding.ItemListaBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemListaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    class ViewHolder(binding: ItemListaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.tvTituloFila
        val contentView: TextView = binding.tvDetalleFila

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}