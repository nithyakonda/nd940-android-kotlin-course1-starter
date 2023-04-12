package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.databinding.LayoutListItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoelistBinding
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentShoelistBinding>(inflater, R.layout.fragment_shoelist, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.addBtn.setOnClickListener { view ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionListingFragmentToDetailsFragment())
        }
        viewModel.shoeList.observe(requireActivity(), Observer { shoeList ->
            if (!shoeList.isEmpty())
                populateList(shoeList)
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun populateList(shoeList : List<Shoe>) {
        val container = binding.listingLinearLayout

        shoeList.forEach {shoeItem ->
            val itemBinding: LayoutListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.layout_list_item, container, false)
            itemBinding.shoe = shoeItem

            container.addView(itemBinding.root)
        }
    }
}