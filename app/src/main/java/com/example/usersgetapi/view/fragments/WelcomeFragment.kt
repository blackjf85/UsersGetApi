package com.example.usersgetapi.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.usersgetapi.databinding.FragmentWelcomeBinding

class WelcomeFragment: Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            continueBtn.setOnClickListener {
                val directions =
                    WelcomeFragmentDirections.actionWelcomeFragmentToUserFragment()
                findNavController().navigate(directions)
            }

            postBtn.setOnClickListener {
                val directions =
                    WelcomeFragmentDirections.actionWelcomeFragmentToPostFragment()
                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}