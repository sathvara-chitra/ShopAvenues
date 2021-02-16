package com.dexterapp.shopavenues.model

class AddressModel{
    private var name: String? = null
    private var number: String? = null
    private var desc: String? = null

    fun AddressModel(name: String?, number: String?, desc: String?) {
        this.name = name
        this.number = number
        this.desc = desc
    }

    fun getname(): String? {
        return name
    }

    fun setname(name: String?) {
        this.name = name
    }

    fun getnumber(): String? {
        return number
    }

    fun setnumber(number: String?) {
        this.number = number
    }
    fun getdesc(): String? {
        return desc
    }

    fun setdesc(desc: String?) {
        this.desc = desc
    }
}