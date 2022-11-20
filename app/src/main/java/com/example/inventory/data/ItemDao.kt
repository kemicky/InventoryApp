package com.example.inventory.data


/**
Author: Kemmy MO Jones
Project: InventoryApp
Date: 2022/11/20
Email: mjkonceptz@gmail.com
Copyright (c) 2022 MJKonceptz. All rights reserved.
 */

import kotlinx.coroutines.flow.Flow
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

//MARK: Annotate this interface class with @Dao Keyword

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * from item WHERE id = :id")
    fun getItem(id: Int): Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>


} //end: ItemDao