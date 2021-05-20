package com.example.calculatorkt.repository.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CalcModel(
    @PrimaryKey val id: Int,
    val result: String?,
    val action: String?
)