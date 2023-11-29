package com.example.jsondataapp.api

import com.example.jsondataapp.data.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/posts/{postId}")
    suspend fun getPost(@Path("postId") postId: Long): Response<Post>

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}
