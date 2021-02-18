package com.dexterapp.shopavenues.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dexterapp.shopavenues.R
import com.dexterapp.shopavenues.activity.FilterAcademyActivity
import com.dexterapp.shopavenues.adapter.*
import com.dexterapp.shopavenues.model.tabname
import com.synnapps.carouselview.CarouselView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), AvenuesListAdapter.onAvenueListClick {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var ll_home: LinearLayout? = null
    private var ll_trending: LinearLayout? = null

    private var ll_academy: LinearLayout? = null
    private var txtTranding: TextView? = null
    private var txtFilter: TextView? = null
    private var tab_male: TextView? = null
    private var tab_female: TextView? = null
    private var tab_avenues: TextView? = null
    private var tab_celebrity: TextView? = null
    private var tab_sale: TextView? = null

    private var viewMale: LinearLayout? = null
    private var viewFemale: LinearLayout? = null
    private var viewAvenue: LinearLayout? = null
    private var viewCelebrity: LinearLayout? = null
    private var viewSale: LinearLayout? = null

    private lateinit var carouselView: CarouselView
    private lateinit var tabRv: RecyclerView
    private var tablist: ArrayList<tabname>? = arrayListOf()
    private lateinit var shopforRv: RecyclerView
    private lateinit var avenuesRv: RecyclerView
    private lateinit var brandRv: RecyclerView
    private lateinit var TrandingRv: RecyclerView
    private lateinit var acedemy_rv: RecyclerView
    val arrayAvenue: ArrayList<String> = ArrayList()
    val arrayAvenue1: ArrayList<String> = ArrayList()

    val sampleImages = intArrayOf(
        R.drawable.crousel_demo,
        R.drawable.crousel_demo,
        R.drawable.crousel_demo,
    )
    val images = intArrayOf(
        R.drawable.maledemo,
        R.drawable.femaledemo,
        R.drawable.maledemo,
    )
    val imagesavenues = intArrayOf(
        R.drawable.avenuesdemo,
        R.drawable.footballdemo,
        R.drawable.golfdemo,
    )
    val imagesavenues1 = intArrayOf(
        R.drawable.academydemo3,
        R.drawable.academydemo2,
        R.drawable.academydemo1,
    )

    val imagesbrands = intArrayOf(
        R.drawable.b1,
        R.drawable.b2,
        R.drawable.b3,
        R.drawable.b4,
        R.drawable.b5,
        R.drawable.b6,
        R.drawable.b7
    )
    val imagestrending = intArrayOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4

    )

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
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val context = view.context
        // Inflate the layout for this fragment

        ll_home = view.findViewById(R.id.ll_home)
        ll_trending = view.findViewById(R.id.ll_trending)
        txtFilter = view.findViewById(R.id.txtFilter)
        ll_academy = view.findViewById(R.id.ll_academy)
        txtTranding = view.findViewById(R.id.txtTranding)
        tab_male = view.findViewById(R.id.tab_male)
        tab_female = view.findViewById(R.id.tab_female)
        tab_avenues = view.findViewById(R.id.tab_avenues)
        tab_celebrity = view.findViewById(R.id.tab_celebrity)
        tab_sale = view.findViewById(R.id.tab_sale)
        shopforRv = view.findViewById(R.id.shopfor_rv)
        avenuesRv = view.findViewById(R.id.avenues_rv)
        brandRv = view.findViewById(R.id.brand_rv)
        TrandingRv = view.findViewById(R.id.tranding_rv)
        acedemy_rv = view.findViewById(R.id.acedemy_rv)
        carouselView = view.findViewById(R.id.carouselView)

        viewMale = view.findViewById(R.id.viewMale)
        viewFemale = view.findViewById(R.id.viewFemale)
        viewAvenue = view.findViewById(R.id.viewAvenue)
        viewCelebrity = view.findViewById(R.id.viewCelebrity)
        viewSale = view.findViewById(R.id.viewSale)


        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(sampleImages[position])
        }

        val shopforAdapter = shopforAdapter(images, context)
        val avenuesAdapter = AvenuesAdapter(imagesavenues, context)
        val brandAdapter = BrandAdapter(imagesbrands, context)
        val trandingAdapter = TrandingAdapter(imagestrending, context)

        shopforRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        avenuesRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        brandRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        brandRv.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        TrandingRv.layoutManager = GridLayoutManager(context, 2)
        shopforRv.adapter = shopforAdapter
        avenuesRv.adapter = avenuesAdapter
        brandRv.adapter = brandAdapter
        TrandingRv.adapter = trandingAdapter

        onClick()
        return view
    }

    private fun onClick() {
        txtFilter!!.setOnClickListener {
            val mainIntent = Intent(activity, FilterAcademyActivity::class.java)
            startActivity(mainIntent)
        }
        tab_sale!!.setOnClickListener {
            txtTranding!!.setText("Sale")
            ll_home!!.visibility = View.GONE
            ll_academy!!.visibility = View.GONE
            ll_trending!!.visibility = View.VISIBLE
            viewSale!!.visibility = View.VISIBLE
            viewMale!!.visibility = View.INVISIBLE
            viewFemale!!.visibility = View.INVISIBLE
            viewAvenue!!.visibility = View.INVISIBLE
            viewCelebrity!!.visibility = View.INVISIBLE
            tab_sale!!.setTextColor(resources.getColor(R.color.color_textred))
            tab_male!!.setTextColor(resources.getColor(R.color.white))
            tab_female!!.setTextColor(resources.getColor(R.color.white))
            tab_avenues!!.setTextColor(resources.getColor(R.color.white))
            tab_celebrity!!.setTextColor(resources.getColor(R.color.white))
            TrandingRv.layoutManager = GridLayoutManager(context, 2)
            val trandingAdapter = TrandingAdapter(imagestrending, activity!!)
            TrandingRv.adapter = trandingAdapter

        }

        tab_male!!.setOnClickListener {
            txtTranding!!.setText("Male")
            ll_home!!.visibility = View.GONE
            ll_academy!!.visibility = View.GONE
            ll_trending!!.visibility = View.VISIBLE
            viewSale!!.visibility = View.INVISIBLE
            viewMale!!.visibility = View.VISIBLE
            viewFemale!!.visibility = View.INVISIBLE
            viewAvenue!!.visibility = View.INVISIBLE
            viewCelebrity!!.visibility = View.INVISIBLE
            tab_sale!!.setTextColor(resources.getColor(R.color.white))
            tab_male!!.setTextColor(resources.getColor(R.color.color_textred))
            tab_female!!.setTextColor(resources.getColor(R.color.white))
            tab_avenues!!.setTextColor(resources.getColor(R.color.white))
            tab_celebrity!!.setTextColor(resources.getColor(R.color.white))
            TrandingRv.layoutManager = GridLayoutManager(context, 2)
            val trandingAdapter = TrandingAdapter(imagestrending, activity!!)
            TrandingRv.adapter = trandingAdapter
        }

        tab_female!!.setOnClickListener {
            txtTranding!!.setText("Female")
            ll_home!!.visibility = View.GONE
            ll_academy!!.visibility = View.GONE
            ll_trending!!.visibility = View.VISIBLE
            viewSale!!.visibility = View.INVISIBLE
            viewMale!!.visibility = View.INVISIBLE
            viewFemale!!.visibility = View.VISIBLE
            viewAvenue!!.visibility = View.INVISIBLE
            viewCelebrity!!.visibility = View.INVISIBLE
            tab_sale!!.setTextColor(resources.getColor(R.color.white))
            tab_male!!.setTextColor(resources.getColor(R.color.white))
            tab_female!!.setTextColor(resources.getColor(R.color.color_textred))
            tab_avenues!!.setTextColor(resources.getColor(R.color.white))
            tab_celebrity!!.setTextColor(resources.getColor(R.color.white))
            TrandingRv.layoutManager = GridLayoutManager(context, 2)
            val trandingAdapter = TrandingAdapter(imagestrending, activity!!)
            TrandingRv.adapter = trandingAdapter
        }

        tab_avenues!!.setOnClickListener {

            txtTranding!!.setText("Avenues")
            ll_home!!.visibility = View.GONE
            ll_academy!!.visibility = View.GONE
            ll_trending!!.visibility = View.VISIBLE
            viewSale!!.visibility = View.INVISIBLE
            viewMale!!.visibility = View.INVISIBLE
            viewFemale!!.visibility = View.INVISIBLE
            viewAvenue!!.visibility = View.VISIBLE
            viewCelebrity!!.visibility = View.INVISIBLE
            tab_sale!!.setTextColor(resources.getColor(R.color.white))
            tab_male!!.setTextColor(resources.getColor(R.color.white))
            tab_female!!.setTextColor(resources.getColor(R.color.white))
            tab_avenues!!.setTextColor(resources.getColor(R.color.color_textred))
            tab_celebrity!!.setTextColor(resources.getColor(R.color.white))
            arrayAvenue!!.add("Basketball")
            arrayAvenue!!.add("Football")
            arrayAvenue!!.add("Golf")
            TrandingRv.layoutManager = GridLayoutManager(context, 1)
            val avenuesAdapter = AvenuesListAdapter(imagesavenues, arrayAvenue, activity!!, this)
            TrandingRv.adapter = avenuesAdapter

        }
        tab_celebrity!!.setOnClickListener {
            txtTranding!!.setText("Celebrity")
            ll_home!!.visibility = View.GONE
            ll_trending!!.visibility = View.VISIBLE
            ll_academy!!.visibility = View.GONE
            viewSale!!.visibility = View.INVISIBLE
            viewMale!!.visibility = View.INVISIBLE
            viewFemale!!.visibility = View.INVISIBLE
            viewAvenue!!.visibility = View.INVISIBLE
            viewCelebrity!!.visibility = View.VISIBLE
            tab_sale!!.setTextColor(resources.getColor(R.color.white))
            tab_male!!.setTextColor(resources.getColor(R.color.white))
            tab_female!!.setTextColor(resources.getColor(R.color.white))
            tab_avenues!!.setTextColor(resources.getColor(R.color.white))
            tab_celebrity!!.setTextColor(resources.getColor(R.color.color_textred))
            arrayAvenue1!!.add("Cristiano Ronaldo")
            arrayAvenue1!!.add("Martin Garrix")
            arrayAvenue1!!.add("Cristiano Ronaldo")
            TrandingRv.layoutManager = GridLayoutManager(context, 1)
            val avenuesAdapter = CelebrityListAdapter(arrayAvenue1, activity!!)
            TrandingRv.adapter = avenuesAdapter
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onAvenueListClick() {
        acedemy_rv.layoutManager = GridLayoutManager(context, 1)
        txtTranding!!.setText("Avenues")
        ll_home!!.visibility = View.GONE
        ll_trending!!.visibility = View.GONE
        ll_academy!!.visibility = View.VISIBLE
        viewSale!!.visibility = View.INVISIBLE
        viewMale!!.visibility = View.INVISIBLE
        viewFemale!!.visibility = View.INVISIBLE
        viewAvenue!!.visibility = View.VISIBLE
        viewCelebrity!!.visibility = View.INVISIBLE
        tab_sale!!.setTextColor(resources.getColor(R.color.white))
        tab_male!!.setTextColor(resources.getColor(R.color.white))
        tab_female!!.setTextColor(resources.getColor(R.color.white))
        tab_avenues!!.setTextColor(resources.getColor(R.color.color_textred))
        tab_celebrity!!.setTextColor(resources.getColor(R.color.white))
        val avenuesAdapter = AcademyListAdapter(imagesavenues1, activity!!)
        acedemy_rv.adapter = avenuesAdapter
    }
}