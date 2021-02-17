package com.dexterapp.shopavenues.model

class SizeModel {
    private var name: String? = null
    private var type: String? = null

    fun FilterModel(name: String?, type: String?) {
        this.name = name
        this.type = type
    }

    fun getname(): String? {
        return name
    }

    fun setname(name: String?) {
        this.name = name
    }

    fun gettype(): String? {
        return type
    }

    fun settype(type: String?) {
        this.type = type
    }


}