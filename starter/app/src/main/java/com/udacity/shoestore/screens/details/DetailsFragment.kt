package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoelist.ShoeListViewModel

class DetailsFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentDetailsBinding>(inflater, R.layout.fragment_details, container, false)
        binding.shoe = Shoe("", 0.0, "", "")
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.saveBtn.setOnClickListener { view ->
            viewModel.onSave(binding.shoe!!)
            view.findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToListingFragment())
        }
        binding.cancelBtn.setOnClickListener { view ->
            view.findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToListingFragment())
        }

        return binding.root
    }
}