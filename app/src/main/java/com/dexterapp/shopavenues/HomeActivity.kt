package com.dexterapp.shopavenues

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dexterapp.shopavenues.fragments.CartFragment
import com.dexterapp.shopavenues.fragments.HomeFragment
import com.dexterapp.shopavenues.fragments.ProfileFragment
import com.dexterapp.shopavenues.fragments.WishlistFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init()
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val favFragment = HomeFragment.newInstance("", "")
                    openFragment(favFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_wishlist -> {
                    val favFragment = WishlistFragment.newInstance("", "")
                    openFragment(favFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_cart -> {
                    val favFragment = CartFragment.newInstance("", "")
                    openFragment(favFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    val favFragment = ProfileFragment.newInstance("", "")
                    openFragment(favFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private fun init() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.itemIconTintList = null

        //Default
        val homeFragment = HomeFragment.newInstance("", "")
        openFragment(homeFragment)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        finish()
    }
}