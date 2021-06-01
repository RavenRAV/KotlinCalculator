package com.example.calculatorkt.view

import android.util.Log
import androidx.annotation.IdRes
import androidx.lifecycle.MutableLiveData
import com.example.calculatorkt.R
import com.example.calculatorkt.base.BaseViewModel
import com.example.calculatorkt.util.Value
import java.lang.Exception

class CalculatorViewModel : BaseViewModel() {

    var mathLiveData = MutableLiveData<String>()
    var resultLiveData = MutableLiveData<String>()
    var operationLiveData = MutableLiveData<String>()

    private var math: String = String()
    private var operationVal: String = String()


    enum class Operation(
        @IdRes var id: Int,
        var value: String? = null,
        var operation: String? = null
    ) {
        One(R.id.b1, "1"),
        Two(R.id.b2, "2"),
        Three(R.id.b3, "3"),
        Four(R.id.b4, "4"),
        Five(R.id.b5, "5"),
        Six(R.id.b6, "6"),
        Seven(R.id.b7, "7"),
        Eight(R.id.b8, "8"),
        Nine(R.id.b9, "9"),
        Zero(R.id.b0, "0"),
        DubZero(R.id.b00, "00"),

        Plus(R.id.plus, operation = " + "),
        Minus(R.id.minus, operation = " - "),
        Multiply(R.id.multiply, operation = " * "),
        Dev(R.id.dev, operation = " / "),
        Percent(R.id.percent, operation = " % "),


        Equally(R.id.equally),
        Clear(R.id.clear),
        BackSpace(R.id.backspace);

        companion object {
            fun valueOf(@IdRes id: Int) = values().find { it.id == id }
        }
    }

    private val operations = listOf(" + ", " - ", " * ", " / ", " % ")

    init {
        mathLiveData.value = "0"
        resultLiveData.value = "0"
    }

    fun onClick(@IdRes id: Int) {
        val operation = Operation.valueOf(id)

        if (operation?.value != null) {
            math += operation.value

            mathLiveData.value = math
        } else if (operation?.operation != null) {
            operations.forEach { if (math.takeLast(3).contains(it)) { return } }

            math += operation.operation
            operationVal = operation.operation!!

            mathLiveData.value = math
            operationLiveData.value = operationVal
        } else {
            when (operation) {
                Operation.Clear -> clear()
                Operation.BackSpace -> backSpace()
                Operation.Equally -> equally()
//                    if (operation.value != null){
//                        math = (math.toInt()/100).toString()
//
//                        resultLiveData.value = math
//                        mathLiveData.value = math
//                    }
            }
        }

        mathResult()
    }

    private fun mathResult() {
        try {
            resultLiveData.value = Value(math).resolve().toString()
        } catch (e: Exception) {
            resultLiveData.value = String()
        }
    }

    private fun equally() {
        try {
            math = Value(math).resolve().toString()

            mathLiveData.value = math
            resultLiveData.value = String()
            operationLiveData.value = String()
        } catch (e: Exception) {
            Log.e("CalculatorViewModel", e.message.toString())
        }
    }

    private fun backSpace() {
        operations.forEach {
            if (math.takeLast(3).contains(it)) {
                math = math.dropLast(3)
                mathLiveData.value = math
                return
            }
        }

        math = math.dropLast(1)
        mathLiveData.value = math
    }

    private fun clear() {
        math = String()

        resultLiveData.value = "0"
        mathLiveData.value = String()
        operationLiveData.value = String()
    }
}