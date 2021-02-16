package com.dexterapp.shopavenues.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.activity.AddressListActivity
import com.dexterapp.shopavenues.activity.ProfileActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var btnProfile: TextView? = null
    private var btnAddress: TextView? = null
    private var btnTransaction: TextView? = null

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
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        init(root)
        OnClick()
        return root
    }


    private fun init(root: View) {

        btnProfile = root.findViewById(R.id.btnProfile) as TextView
        btnAddress = root.findViewById(R.id.btnAddress) as TextView
        btnTransaction = root.findViewById(R.id.btnTransaction) as TextView

    }

    private fun OnClick() {
        btnProfile!!.setOnClickListener {
            val mainIntent = Intent(activity, ProfileActivity::class.java)
            startActivity(mainIntent)
        }
        btnAddress!!.setOnClickListener {
            val mainIntent = Intent(activity, AddressListActivity::class.java)
            startActivity(mainIntent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}