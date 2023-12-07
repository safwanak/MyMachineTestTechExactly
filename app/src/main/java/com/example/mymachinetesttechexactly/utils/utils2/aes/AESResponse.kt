package com.user.nestmarket.utils.aes

import com.google.gson.annotations.SerializedName

data class AESResponse(
    @field:SerializedName("success")
    var success: Boolean = false,

    @field:SerializedName("message")
    var message: String = "",
)
