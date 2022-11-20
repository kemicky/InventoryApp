@file:OptIn(InternalCoroutinesApi::class)

package com.example.inventory.data


/**
Author: Kemmy MO Jones
Project: InventoryApp
Date: 2022/11/20
Email: mjkonceptz@gmail.com
Copyright (c) 2022 MJKonceptz. All rights reserved.
 */

//MARK: Import  the necessary libraries
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

import kotlinx.coroutines.internal.synchronized

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ItemRoomDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object{
        @Volatile
        private var INSTANCE: ItemRoomDatabase? = null

        fun getDatabase(context: Context): ItemRoomDatabase{

            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                instance

            }//end: return instance

        }//end: getDatabase

    }//end:companion Object
} //end: ItemRoomDatabase class