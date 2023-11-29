package com.example.jsondataapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jsondataapp.R
import com.example.jsondataapp.data.Post
import com.example.jsondataapp.viewmodel.PostListViewModel

class PostListFragment : Fragment(R.layout.post_list_fragment) {
    private lateinit var viewModel: PostListViewModel
    private lateinit var postListAdapter: PostListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(this)[PostListViewModel::class.java]
        viewModel.getPostList().observe(viewLifecycleOwner) { posts -> postListAdapter = PostListAdapter(posts) { selectedPost -> navigateToPostDetail(selectedPost) }
            recyclerView.adapter = postListAdapter
        }
    }

    private fun navigateToPostDetail(post: Post) {
        val action = PostListFragmentDirections.actionPostListFragmentToPostDetailFragment(post)
        findNavController().navigate(action)
    }
}