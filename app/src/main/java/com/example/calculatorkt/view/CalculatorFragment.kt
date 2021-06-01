package com.example.calculatorkt.view

import android.os.Bundle
import android.view.View
import com.example.calculatorkt.base.BaseFragment
import com.example.calculatorkt.databinding.FragmentCalculatorBinding

class CalculatorFragment : BaseFragment<FragmentCalculatorBinding, CalculatorViewModel>(FragmentCalculatorBinding::inflate, CalculatorViewModel::class.java), View.OnClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupObserve()
    }

    private fun setupUI() {
        binding.b1.setOnClickListener(this)
        binding.b2.setOnClickListener(this)
        binding.b3.setOnClickListener(this)
        binding.b4.setOnClickListener(this)
        binding.b5.setOnClickListener(this)
        binding.b6.setOnClickListener(this)
        binding.b7.setOnClickListener(this)
        binding.b8.setOnClickListener(this)
        binding.b9.setOnClickListener(this)
        binding.b0.setOnClickListener(this)
        binding.b00.setOnClickListener(this)

        binding.plus.setOnClickListener(this)
        binding.minus.setOnClickListener(this)
        binding.multiply.setOnClickListener(this)
        binding.dev.setOnClickListener(this)
        binding.equally.setOnClickListener(this)
        binding.clear.setOnClickListener(this)
        binding.backspace.setOnClickListener(this)
        binding.percent.setOnClickListener (this)
    }

    private fun setupObserve() {
        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            binding.enteredValue.text = it
        }

        viewModel.mathLiveData.observe(viewLifecycleOwner) {
            binding.result.text = it
        }

        viewModel.operationLiveData.observe(viewLifecycleOwner) {
            binding.action.text = it
        }
    }

    override fun onClick(view: View?) {
        view?.id?.let { id -> viewModel.onClick(id) }
    }
}