package com.example.usersgetapi.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersgetapi.adapters.PostAdapter
import com.example.usersgetapi.databinding.FragmentPostBinding
import com.example.usersgetapi.model.network.ApiManager
import com.example.usersgetapi.model.repository.PostRepository
import com.example.usersgetapi.viewmodel.PostsViewModel

class PostFragment: Fragment() {
    private var _binding: FragmentPostBinding? = null
    private val binding: FragmentPostBinding get() = _binding!!

    private val viewModel: PostsViewModel by activityViewModels {
        PostsViewModel.Factory(PostRepository(ApiManager()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            viewModel.posts.observe(viewLifecycleOwner){post ->
                postRv.apply {
                    adapter = post?.let { PostAdapter(it) }
                    layoutManager =
                        LinearLayoutManager(requireContext())
                }
            }
            backBtn.setOnClickListener {
                val directions =
                    PostFragmentDirections.actionPostFragmentToWelcomeFragment()
                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}