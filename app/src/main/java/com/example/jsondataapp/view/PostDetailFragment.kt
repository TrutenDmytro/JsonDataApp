package com.example.jsondataapp.view

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.jsondataapp.R
import com.example.jsondataapp.data.Post
import com.example.jsondataapp.viewmodel.PostDetailViewModel

class PostDetailFragment : Fragment(R.layout.post_detail_fragment) {

    private lateinit var viewModel: PostDetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val post: Post = PostDetailFragmentArgs.fromBundle(requireArguments()).post
        viewModel = ViewModelProvider(this)[PostDetailViewModel::class.java]
        observeViewModel()
        viewModel.getPost(post.id)
    }

    private fun observeViewModel() {
        viewModel.post.observe(viewLifecycleOwner) { post ->
            updateUI(post)
        }
    }

    private fun updateUI(post: Post) {
        val idTextView: TextView = view?.findViewById(R.id.id) ?: return
        val userIdTextView: TextView = view?.findViewById(R.id.userId) ?: return
        val titleTextView: TextView = view?.findViewById(R.id.title) ?: return
        val bodyTextView: TextView = view?.findViewById(R.id.body) ?: return

        idTextView.text = "ID: " + post.id.toString()
        userIdTextView.text = "User ID: " + post.userId.toString()
        titleTextView.text = post.title
        bodyTextView.text = post.body
    }
}