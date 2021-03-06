package com.binar.chapter4b

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnPertama.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("judul")
                .setMessage("CONTOH PESAN DARI ALERT DIALOG STANDART")
                .setIcon(R.drawable.ic_launcher_background)
                .show()
        }
        btnKedua.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("HAPUS DATA")
                .setMessage("YAKIN HAPUS DATA ?")
                .setCancelable(false)
                .setPositiveButton("YA"){dialogInterface : DialogInterface, i : Int ->
                    Toast.makeText(this, "DATA ANDA TERHAPIUS", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("TIDAK") {dialogInterface2 : DialogInterface, i : Int ->
                    Toast.makeText(this, "TIDAK JADI", Toast.LENGTH_LONG).show()
                }
                .show()
        }
        btnKetiga.setOnClickListener {
            val aa = AlertDialog.Builder(this)
            val bb = aa.create()
            aa.setTitle("dismiss")
            aa.setMessage("ISI MESSAGE DARI EXAMPLE OF DISMISS")
            aa.setPositiveButton("ya"){dialog : DialogInterface, i :Int ->
                Toast.makeText(this, "TOAST YA", Toast.LENGTH_LONG).show()
            }
            aa.setNeutralButton("netral"){dialog : DialogInterface, i : Int ->
                bb.dismiss()
            }
                .show()
        }
        btnKeempat.setOnClickListener {
            val aa = AlertDialog.Builder(this)
            val bb = aa.create()
            val customDialog = LayoutInflater.from(this).inflate(androidx.core.R.layout.custom_dialog, null, false)

                aa.setView(customDialog)
                aa.create()
                aa.show()

        }
        btnKelima.setOnClickListener {
            AlertDialog().show(supportFragmentManager, "abc")
        }
    }
}