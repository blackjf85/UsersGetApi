package com.example.usersgetapi.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.usersgetapi.databinding.ItemPostBinding
import com.example.usersgetapi.model.network.models.Post

class PostAdapter(
    private val postList: List<Post>
): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostViewHolder(private val binding: ItemPostBinding):
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(post: Post) {
            with(binding){
                userIdTv.text = "User ${post.userId}"
                idTv.text = "Post Number: ${post.id}"
                titleTv.text = post.title
                bodyTv.text = post.body
            }
        }
    }
}