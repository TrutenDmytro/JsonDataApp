package com.example.jsondataapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jsondataapp.R
import com.example.jsondataapp.data.Post

class PostListAdapter(private val posts: List<Post>, private val onItemClick: (Post) -> Unit) :
    RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.postTextView)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClick(posts[position])
                }
            }
        }

        fun bind(post: Post) {
            titleTextView.text = "Post №" + post.id + " " + post.title
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val posts = posts[position]
        holder.bind(posts)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}