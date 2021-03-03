package com.dexterapp.shopavenues.network

import com.dexterapp.shopavenues.login.model.loginResponse
import com.dexterapp.shopavenues.util.Variable.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET()
    fun Login(email: String, password: String): Call<loginResponse>


    @POST()
    fun signup(fullname: String, email: String, password: String): Call<loginResponse>

}

object ApiObject {
    var api: Api

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(Api::class.java)
    }
}