package com.example.navigationexersice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigationexersice.R
import com.example.navigationexersice.databinding.FragmentSecretBinding

class SecretFragment : Fragment() {
    private var _binding: FragmentSecretBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecretBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCloseSecret.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnCloseBox.setOnClickListener {
            findNavController().popBackStack(R.id.mainFragment, false)
//            val action = SecretFragmentDirections.actionSecretFragmentToMainFragment(0)
//            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}