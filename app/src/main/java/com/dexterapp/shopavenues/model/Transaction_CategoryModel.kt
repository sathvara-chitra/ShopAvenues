package com.dexterapp.shopavenues.model


class Transaction_CategoryModel {
    private var name: String? = null

    private var subcategory: ArrayList<Transaction_SubCategory>? = null
    fun Transaction_CategoryModel(
        name: String?,
        subcategory: ArrayList<Transaction_SubCategory>?
    ) {
        this.name = name
        this.subcategory = subcategory
    }

    fun getname(): String? {
        return name
    }

    fun setname(name: String?) {
        this.name = name
    }

    fun getSubCategory(): ArrayList<Transaction_SubCategory>? {
        return subcategory
    }

    fun setSubCategory(subcategory: ArrayList<Transaction_SubCategory>?) {
        this.subcategory = subcategory
    }


}