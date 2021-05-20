package com.example.calculatorkt.view

import android.os.Bundle
import android.view.View
import com.example.calculatorkt.BaseFragment
import com.example.calculatorkt.databinding.FragmentCalculatorBinding
import kotlinx.coroutines.launch

class CalculatorFragment : BaseFragment<FragmentCalculatorBinding, CalculatorViewModel>(FragmentCalculatorBinding::inflate, CalculatorViewModel::class.java) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {

        binding.b1.setOnClickListener {}
        binding.b2.setOnClickListener {}
        binding.b3.setOnClickListener {}
        binding.b4.setOnClickListener {}
        binding.b5.setOnClickListener {}
        binding.b6.setOnClickListener {}
        binding.b7.setOnClickListener {}
        binding.b8.setOnClickListener {}
        binding.b9.setOnClickListener {}
        binding.b0.setOnClickListener {}
        binding.b00.setOnClickListener {}

        binding.plus.setOnClickListener { }
        binding.minus.setOnClickListener { binding.action.text = "-" }
        binding.multiply.setOnClickListener { binding.action.text = "x" }
        binding.dev.setOnClickListener { binding.action.text = "÷" }
        binding.equally.setOnClickListener {}
        binding.clear.setOnClickListener {
            binding.action.text = ""
            binding.result.text = ""
            binding.enteredValue.text = ""
        }

        binding.backspace.setOnClickListener{
            var res: String = binding.enteredValue.text.toString()
            if(res.isNotEmpty()){
                res = res.substring(0, res.length - 1)
                binding.enteredValue.text = res
            }
        }

        binding.containerForResult.setOnClickListener {
            binding.containerForButtons.visibility = View.GONE
            binding.containerForHistory.visibility = View.VISIBLE
        }

        binding.closeHistory.setOnClickListener {
            binding.containerForButtons.visibility = View.VISIBLE
            binding.containerForHistory.visibility = View.GONE
        }

    }



    private fun numberClick(num: String) {
        if (binding.action.text.isEmpty()) {
            binding.enteredValue.append(binding.enteredValue.append(num).toString())
        }
        if (!binding.action.text.isEmpty()) {
            binding.result.text = binding.enteredValue.text.toString()
        }
    }// выдает знчение+kotlin.Unit


}


//    private fun setListeners() {
//        binding.b1.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b1.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.append("1")
//            }
//        }
//        binding.b2.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b2.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "2"
//            }
//        }
//        binding.b3.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b3.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "3"
//            }
//        }
//        binding.b4.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b4.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "4"
//            }
//        }
//        binding.b5.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b5.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "5"
//            }
//        }
//        binding.b6.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b6.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "6"
//            }
//        }
//        binding.b7.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b7.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "7"
//            }
//        }
//        binding.b8.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b8.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "8"
//            }
//        }
//        binding.b9.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b9.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "9"
//            }
//        }
//        binding.b0.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                binding.enteredValue.append(binding.b0.text.toString())
//            }
//            if (!binding.action.text.isEmpty()) {
//                binding.result.text = binding.enteredValue.text.toString()
//                binding.enteredValue.text = "0"
//            }
//        }
//        binding.b00.setOnClickListener {
//            if (binding.action.text.isEmpty()) {
//                if (!binding.enteredValue.text.isEmpty()) {
//                    binding.enteredValue.append(binding.b00.text.toString())
//                }
//            }
//            if (!binding.action.text.isEmpty()) {
//                if (!binding.enteredValue.text.isEmpty()) {
//                    binding.result.text = binding.enteredValue.text.toString()
//                    binding.enteredValue.text = "0"
//                }
//            }
//        }
//
//        binding.plus.setOnClickListener {
//            if (!binding.enteredValue.text.isEmpty()) binding.action.text = "+"
//            if (!binding.result.text.isEmpty()) binding.enteredValue.text = ""
//        }
//        binding.minus.setOnClickListener { binding.action.text = "-" }
//        binding.multiply.setOnClickListener { binding.action.text = "x" }
//        binding.dev.setOnClickListener { binding.action.text = "÷" }
//        binding.equally.setOnClickListener {
//            if (binding.result.text.isEmpty()) {
//
//                binding.action.text = ""
//            }
//        }
//        binding.clear.setOnClickListener {
//            binding.action.text = ""
//            binding.result.text = ""
//            binding.enteredValue.text = ""
//        }
//
//        binding.backspace.setOnClickListener{
//            var res: String = binding.enteredValue.text.toString()
//            if(res.isNotEmpty()){
//            res = res.substring(0, res.length - 1)
//            binding.enteredValue.text = res
//            }
//        }
//
//    }