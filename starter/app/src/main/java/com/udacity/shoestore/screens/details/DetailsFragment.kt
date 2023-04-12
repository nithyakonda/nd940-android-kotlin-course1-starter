package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.screens.listing.ListingFragmentDirections

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(inflater, R.layout.fragment_details, container, false)

        binding.saveBtn.setOnClickListener { view ->
            onSaveNewItem()
            view.findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToListingFragment())
        }
        binding.cancelBtn.setOnClickListener { view ->
            view.findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToListingFragment())
        }

        return binding.root
    }

    private fun onSaveNewItem() {}
}