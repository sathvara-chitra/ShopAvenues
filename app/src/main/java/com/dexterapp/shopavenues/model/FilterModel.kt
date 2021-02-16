package com.dexterapp.shopavenues.model

class FilterModel{
    private var name: String? = null

    fun FilterModel(name: String?) {
        this.name = name
    }

    fun getname(): String? {
        return name
    }

    fun setname(name: String?) {
        this.name = name
    }


}