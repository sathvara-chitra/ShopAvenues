package com.dexterapp.shopavenues.model

class ProductModel {
    private var name: Int? = null

    fun FilterModel(name: Int?) {
        this.name = name
    }

    fun getname(): Int? {
        return name
    }

    fun setname(name: Int?) {
        this.name = name
    }



}