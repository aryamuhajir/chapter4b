package com.binar.chapter4b.kamis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.item_mhs_adapter.view.*

class AdapterMhs(val listData : ArrayList<DataMhs>): RecyclerView.Adapter<AdapterMhs.ViewHolder>() {
    class ViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMhs.ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_mhs_adapter, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: AdapterMhs.ViewHolder, position: Int) {
        holder.itemView.txNama.text = listData[position].nama
        holder.itemView.txUmur.text = listData[position].umur
        holder.itemView.gambar_rv.setImageResource(listData[position].gambar)

    }

    override fun getItemCount(): Int {
        return listData.size
    }
}