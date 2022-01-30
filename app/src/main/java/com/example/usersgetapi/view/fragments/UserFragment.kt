package com.example.usersgetapi.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersgetapi.databinding.FragmentUserBinding
import com.example.usersgetapi.model.network.ApiManager
import com.example.usersgetapi.model.repository.UserRepository
import com.example.usersgetapi.viewmodel.UsersViewModel
import com.example.usersgetapi.adapters.UserAdapter

class UserFragment:  Fragment(){
    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding get() = _binding!!

    private val viewModel: UsersViewModel by activityViewModels {
        UsersViewModel.Factory(UserRepository(ApiManager()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            viewModel.users.observe(viewLifecycleOwner){user ->
                userRv.apply {
                    adapter = user?.let { UserAdapter(it) }
                    layoutManager =
                        LinearLayoutManager(requireContext())
                }
            }
            backBtn.setOnClickListener {
                val directions =
                    UserFragmentDirections.actionUserFragmentToWelcomeFragment()
                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}