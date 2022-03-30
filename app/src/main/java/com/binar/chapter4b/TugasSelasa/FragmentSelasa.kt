package com.binar.chapter4b.TugasSelasa

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.activity_main_selasa.*
import kotlinx.android.synthetic.main.custom_dialog.view.*
import kotlinx.android.synthetic.main.fragment_selasa.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSelasa.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSelasa : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var dataPasser: OnDataPass


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
        return inflater.inflate(R.layout.fragment_selasa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val dataTotal = arguments?.getString("TOTAL")
        totalBelanja.text = "Rp."+ dataTotal
        var kembalian = 0
        var total =  dataTotal!!.toInt()
        super.onViewCreated(view, savedInstanceState)
        bayar.setOnClickListener {
            val uang = editBayar.text.toString()
            if (uang.toInt() < total){
                editBayar.hint = "UANG TIDAK BOLEH KURANG"
            }else{
                kembalian = uang.toInt() - total
                passData(kembalian)
                dismiss()

            }
        }
    }
    fun passData(data: Int){
        dataPasser.onDataPass(data)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentSelasa.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSelasa().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}