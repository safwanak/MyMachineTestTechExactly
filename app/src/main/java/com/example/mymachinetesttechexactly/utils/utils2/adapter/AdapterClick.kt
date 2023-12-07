package com.user.nestmarket.utils.adapter

interface AdapterClick {
    fun onClickAdapterChild(
        childPosition: Int, type: String
    )
}