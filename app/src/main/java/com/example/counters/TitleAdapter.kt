package com.example.counters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TitleAdapter(private val titles: List<String>, private val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<TitleAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)

        fun bind(title: String) {
            titleTextView.text = title
            itemView.setOnClickListener { onItemClick(title) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_title, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(titles[position])
    }

    override fun getItemCount(): Int = titles.size
}
