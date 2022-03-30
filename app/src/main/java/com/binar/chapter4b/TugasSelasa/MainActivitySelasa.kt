package com.binar.chapter4b.TugasSelasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_selasa.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.totalBelanja
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.fragment_selasa.*

class MainActivitySelasa : AppCompatActivity(), OnDataPass {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_selasa)




        proses1.setOnClickListener {
            if (editBarang.text.isNotBlank() && editJumlah.text.isNotBlank() && editHarga.text.isNotBlank()){
                val  barang = editBarang.text.toString()
                val jumlahx = editJumlah.text.toString()
                val hargax = editHarga.text.toString()
                var total = 0
                var kembalian = 0
                total = jumlahx.toInt() * hargax.toInt()



                val customDialog = LayoutInflater.from(this).inflate(androidx.core.R.layout.custom_dialog, null, false)
                val aa = AlertDialog.Builder(this)
                    .setView(customDialog)
                    .create()
                customDialog.totalBelanja.text = "Rp." + total.toString()
                customDialog.bayar.setOnClickListener {
                    val uang = customDialog.editBayar.text.toString()
                    if (uang.toInt() < total){
                        customDialog.editBayar.hint = "UANG TIDAK BOLEH KURANG"
                    }else{
                        kembalian = uang.toInt() - total
                        cetak(barang, jumlahx.toInt(), hargax.toInt(), total, kembalian)
                        aa.dismiss()

                    }
                }
                aa.show()
            }


        }
        proses2.setOnClickListener {
            if (editBarang.text.isNotBlank() && editJumlah.text.isNotBlank() && editHarga.text.isNotBlank()){
                val dialog = FragmentSelasa()
                var total = editJumlah.text.toString().toInt() * editHarga.text.toString().toInt()

                val bundle = Bundle()
                bundle.putString("TOTAL", total.toString())
                dialog.arguments = bundle
                dialog.show(supportFragmentManager, "abcc")
            }

        }
    }


    private fun cetak(barang: String, jumlah: Int, harga: Int, total: Int, kembalian: Int) {
        namaBarang.text = barang
        jumlahBarang.text = jumlah.toString()
        hargaBarang.text = "Rp." + harga.toString()
        totalBarang.text = "Rp." + total.toString()
        kembalianBarang.text = "Rp." + kembalian.toString()
    }

    override fun onDataPass(data: Int) {
        val  barang = editBarang.text.toString()
        val jumlahx = editJumlah.text.toString()
        val hargax = editHarga.text.toString()
        var total = jumlahx.toInt() * hargax.toInt()
        cetak(barang, jumlahx.toInt(), hargax.toInt(), total, data)



    }

}