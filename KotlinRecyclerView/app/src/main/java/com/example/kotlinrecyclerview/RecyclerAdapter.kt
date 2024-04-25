package com.example.kotlinrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (val dataList: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ListViewHolder>() {
    class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        // Inflater
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.recyclerViewRowTextView).text = dataList[position]
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, SelectedActivity::class.java)
            intent.putExtra("data", dataList[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}