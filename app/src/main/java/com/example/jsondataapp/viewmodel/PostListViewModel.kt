package com.example.jsondataapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsondataapp.api.ApiService
import com.example.jsondataapp.api.RetrofitService
import com.example.jsondataapp.data.Post
import kotlinx.coroutines.launch

class PostListViewModel : ViewModel() {

    private val posts = MutableLiveData<List<Post>>()

    init {
        viewModelScope.launch {
            val retrofit = RetrofitService.getInstance()
            val apiInterface = retrofit.create(ApiService::class.java)
            val response = apiInterface.getPosts()

            try {
                val data = response.body()
                posts.value = data?.let { it }
            } catch (ex: NullPointerException) {
                ex.printStackTrace()
            }
        }
    }

    fun getPostList() = posts
}