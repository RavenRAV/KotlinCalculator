package com.example.calculatorkt.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorkt.R
import com.example.calculatorkt.repository.room.CalcModel

class CalculatorAdapter(private val list : Array<CalcModel>) : RecyclerView.Adapter<CalculatorAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history_recycler, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

    }

    override fun getItemCount() = list.size


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}