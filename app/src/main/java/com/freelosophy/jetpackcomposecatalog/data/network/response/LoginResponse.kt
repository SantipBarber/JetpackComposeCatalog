package com.freelosophy.jetpackcomposecatalog.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success") val success: Boolean
)
