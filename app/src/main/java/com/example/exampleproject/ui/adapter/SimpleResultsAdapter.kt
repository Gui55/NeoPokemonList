package com.example.exampleproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleproject.R
import com.example.exampleproject.services.model.SimplePokeResults

class SimpleResultsAdapter(var results: List<SimplePokeResults>, var context: Context) : RecyclerView.Adapter<SimpleResultsAdapter.SimpleResultsViewHolder>() {
    class SimpleResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById<TextView>(R.id.simple_poke_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleResultsViewHolder {
        return SimpleResultsViewHolder(
                LayoutInflater.from(context).inflate(R.layout.simple_result_recycler_line, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: SimpleResultsViewHolder, position: Int) {
        var aResult = results[position]

        holder.name.text = aResult.name
    }
}