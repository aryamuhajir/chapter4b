package com.binar.chapter4b.kamis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.google_adapter.view.*
import kotlinx.android.synthetic.main.item_mhs_adapter.view.*

class AdapterAPK(val listData : ArrayList<DataAPK>): RecyclerView.Adapter<AdapterAPK.ViewHolder>() {
    class ViewHolder (layout : View) : RecyclerView.ViewHolder(layout) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterAPK.ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.google_adapter, parent, false)
        return ViewHolder(layout)
    }



    override fun onBindViewHolder(holder: AdapterAPK.ViewHolder, position: Int) {
        holder.itemView.namaAPK.text = listData[position].nama
        holder.itemView.namaPT.text = listData[position].pt
        holder.itemView.kategoriAPK.text = listData[position].kategori
        holder.itemView.unduhAPK.text = listData[position].jumlahDN
        holder.itemView.ukuranAPK.text = listData[position].besar
        holder.itemView.ratingAPK.text = listData[position].rate.toString()
        holder.itemView.gambarAPK.setImageResource(listData[position].gambar)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}