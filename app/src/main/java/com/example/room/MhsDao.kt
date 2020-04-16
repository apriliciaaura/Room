package com.example.room

import androidx.room.*

@Dao
interface MhsDao{
    @Query("Select * from mhsentity")
    fun getAll(): List<MhsEntity>

    @Query("Select * from mhsentity where nama like:nama")
    fun findbyName(nama:String):MhsEntity

    @Insert
    fun insertAll(vararg mhsData:MhsEntity)

    @Delete
    fun delete(mhs:MhsEntity)

    @Update
    fun updateData(vararg mhsData:MhsEntity)
}