package com.dexterapp.shopavenues.login.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dexterapp.shopavenues.login.model.loginResponse
import com.dexterapp.shopavenues.network.ApiObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    var LoginList: MutableLiveData<List<loginResponse>>? = null
    var login: ArrayList<loginResponse>? = ArrayList()

    fun onLoginCLick(email: String, password: String): MutableLiveData<List<loginResponse>>? {
        if (LoginList == null) {
            LoginList = MutableLiveData<List<loginResponse>>()
            checkLogin(email, password)
        }

        return LoginList
    }

    private fun checkLogin(email: String, password: String) {
        var call = ApiObject.api.Login(email, password)
        call.enqueue(object : Callback<loginResponse> {
            override fun onResponse(call: Call<loginResponse>, response: Response<loginResponse>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<loginResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}