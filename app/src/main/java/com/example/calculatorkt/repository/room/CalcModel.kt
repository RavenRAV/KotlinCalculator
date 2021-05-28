package com.example.calculatorkt.repository.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CalcModel(
    @PrimaryKey val id: Int,
    val math: String?,
    val result: String?

)