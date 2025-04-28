package com.zhbhun.tester.kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zhbhun.tester.kotlin.databinding.ListItemBinding

data class ListItem(val title: String, val description: String, val onClick: () -> Unit)

class ListItemAdapter(private val itemList: List<ListItem>) :
    RecyclerView.Adapter<ListItemAdapter.ListItemViewHolder>() {
    class ListItemViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleView: TextView = binding.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.titleView.text = item.title

        holder.itemView.setOnClickListener {
            item.onClick()
        }
    }

    override fun getItemCount() = itemList.size
}
