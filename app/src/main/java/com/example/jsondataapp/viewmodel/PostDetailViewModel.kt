package com.example.jsondataapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsondataapp.api.ApiService
import com.example.jsondataapp.api.RetrofitService
import com.example.jsondataapp.data.Post
import kotlinx.coroutines.launch

class PostDetailViewModel : ViewModel() {

    val post = MutableLiveData<Post>()

    fun getPost(postId: Long) {
        viewModelScope.launch {
            try {
                val retrofit = RetrofitService.getInstance()
                val apiInterface = retrofit.create(ApiService::class.java)

                val response = apiInterface.getPost(postId)
                if (response.isSuccessful) {
                    val data = response.body() ?: throw NullPointerException("Post is null")
                    post.value = data
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}