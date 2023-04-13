package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.screens.shoelist.ShoeListViewModel


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.loginBtn.setOnClickListener { view ->
            login()
        }
        binding.signupBtn.setOnClickListener { view ->
            login()
        }

        return binding.root
    }

    private fun login() {
        if (inputValidationSuccess()) {
            if (viewModel.hasLoggedIn.value!!) {
                this.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment())
            } else {
                viewModel.onLogin()
                this.findNavController()
                    .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
    }

    private fun inputValidationSuccess() : Boolean {
        binding.apply {
            if (usernameEt.length() == 0) {
                usernameEt.error = getString(R.string.empty_input_validation_error)
            }
            if(passwordEt.length() == 0) {
                passwordEt.error = getString(R.string.empty_input_validation_error)
            } else {
               return true
            }
        }
        return false
    }

}