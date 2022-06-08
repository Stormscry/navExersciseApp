package com.example.navigationexersice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationexersice.R
import com.example.navigationexersice.databinding.FragmentBoxBinding
import kotlin.properties.Delegates

class BoxFragment : Fragment() {
    private var _binding: FragmentBoxBinding? = null
    private val binding get() = _binding!!

    //private var boxColor by Delegates.notNull<Long>()

    private val args: BoxFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let{
//            boxColor = it.getLong(ARG_COLOR_ID)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoxBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setBackgroundColor(args.colorId.toInt())

        binding.btnGoBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.btnGenerateNumberAndGoBack.setOnClickListener {
            val randNum = (0..100).random()
            setFragmentResult(REQUEST_KEY, bundleOf(ARG_RAND_NUM to randNum))
            findNavController().popBackStack()
        }
        binding.btnOpenSecret.setOnClickListener {
//            val action = BoxFragmentDirections.actionBoxFragmentToSecretFragment()
//            findNavController().navigate(action)
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
        }
    }

    companion object{
        //const val ARG_COLOR_ID = "colorId"
        const val REQUEST_KEY = "request_key"
        const val ARG_RAND_NUM = "rand_num"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}