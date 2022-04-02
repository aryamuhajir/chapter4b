 package com.binar.chapter4b.TugasSabtu

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.binar.chapter4b.R
import com.binar.chapter4b.jumat.Shared
import kotlinx.android.synthetic.main.activity_shared_dua.*
import kotlinx.android.synthetic.main.fragment_welcome.*

 // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Welcome.newInstance] factory method to
 * create an instance of this fragment.
 */
class Welcome : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var sf : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sf = requireActivity().getSharedPreferences("datalogin", Context.MODE_PRIVATE)
        val getNama = sf.getString("NAMA","")
        usernameTxt.text = getNama

        btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("LOGOUT")
                .setMessage("YAKIN LOGOUT ?")
                .setCancelable(true)
                .setPositiveButton("YA"){ dialogInterface : DialogInterface, i : Int ->
                    logout()
                }
                .setNegativeButton("TIDAK") { dialogInterface2 : DialogInterface, i : Int ->

                }
                .show()
        }
    }

    fun logout(){
        val logoutsf = sf.edit()
        logoutsf.clear()
        logoutsf.apply()

        Navigation.findNavController(requireView()).navigate(R.id.action_welcome_to_login)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Welcome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Welcome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}