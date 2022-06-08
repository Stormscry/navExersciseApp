package com.example.navigationexersice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navigationexersice.R
import com.example.navigationexersice.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOpenGreenBox.setOnClickListener {
            openBox(ResourcesCompat.getColor(resources, R.color.green, null), "Green")
        }
        binding.btnOpenYellowBox.setOnClickListener {
            openBox(ResourcesCompat.getColor(resources, R.color.yellow, null), "Yellow")
        }

        setFragmentResultListener(BoxFragment.REQUEST_KEY) { _, res ->
            val randNum = res.getInt(BoxFragment.ARG_RAND_NUM)
            Toast.makeText(requireContext(), "genereted number = $randNum", Toast.LENGTH_SHORT).show()
        }

    }

    private fun openBox(colorId: Int, colorName: String) {
        val action = MainFragmentDirections.actionMainFragmentToBoxFragment(colorId.toLong(), colorName)
        findNavController().navigate(action)
        //если без использования safe args, то так
        //findNavController().navigate(R.id.action_mainFragment_to_boxFragment, bundleOf("key" to colorId))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}