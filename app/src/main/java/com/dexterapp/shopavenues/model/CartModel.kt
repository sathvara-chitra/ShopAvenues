package com.dexterapp.shopavenues.model

class CartModel {
    private var name: String? = null
    val Size: String? = null
    val Quantity: String? = null
    val QAR: String? = null

    fun CartModel(
        name: String?
    ) {
        this.name = name
    }

    fun getname(): String? {
        return name
    }

    fun setname(name: String?) {
        this.name = name
    }


}