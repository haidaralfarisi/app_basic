package com.dicoding.androidaplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.androidaplication.databinding.ItemRowTanamanBinding

class ListHeroAdapter(private val listTanaman: ArrayList<Tanaman>,
                      private val listener: (Tanaman) -> Unit) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tanaman, parent, false)
        val binding=ItemRowTanamanBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listTanaman[position]
        holder.itemView.setOnClickListener{listener(listTanaman[position])}
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
    }

    override fun getItemCount(): Int = listTanaman.size

    class ListViewHolder(var binding: ItemRowTanamanBinding) : RecyclerView.ViewHolder(binding.root)
}