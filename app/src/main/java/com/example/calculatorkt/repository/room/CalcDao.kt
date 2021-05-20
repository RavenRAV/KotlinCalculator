package com.example.calculatorkt.repository.room

import androidx.room.*

@Dao
interface CalcDao {
    @Query("SELECT * FROM calcmodel")
    fun getAll(): List<CalcModel>

    @Insert
    fun insert(calcModel: CalcModel)

    @Update
    fun update(calcModel: CalcModel)

    @Query(" delete from calcmodel")
    fun deleteAllModels()
}