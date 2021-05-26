package com.example.calculatorkt.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<Binding: ViewBinding, VM: BaseViewModel>
    (private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> Binding, className: Class<VM>): Fragment() {

    private var _binding: Binding? = null
    val binding get() = _binding!!

    val viewModel: VM by lazy {
        ViewModelProvider(this).get(className)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView( ) {
        super.onDestroyView()
        _binding = null
    }
}