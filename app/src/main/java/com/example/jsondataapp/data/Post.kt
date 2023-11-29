package com.example.jsondataapp.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Post(
    @SerializedName("id")
    var id: Long,
    @SerializedName("userId")
    var userId: Long,
    @SerializedName("title")
    var title: String,
    @SerializedName("body")
    var body: String
) : Serializable
