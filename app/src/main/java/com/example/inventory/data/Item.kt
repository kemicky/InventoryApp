package com.example.inventory.data

/**
Author: Kemmy MO Jones
Project: InventoryApp
Date: 2022/11/20
Email: mjkonceptz@gmail.com
Copyright (c) 2022 MJKonceptz. All rights reserved.
 */

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import java.text.NumberFormat

/* Mark Class Item with the keyword: data &  Mark the data class with @Entity(table) */

@Entity(tableName = "item")
data class Item (
    //Class Item with a primary constructor.

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val itemName: String,

    @ColumnInfo(name = "price")
    val itemPrice: Double,

    @ColumnInfo(name = "quantity")
    val quantityInStock: Int

) //end: Item class

/**Create an extension to format price & don't forget to import java.text.NumberFormat.*/
fun Item.getFormattedPrice(): String =
    NumberFormat.getCurrencyInstance().format(itemPrice)