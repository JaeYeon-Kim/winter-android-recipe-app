package com.surivalcoding.composerecipeapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters


/*
* Room의 Entity
* ingredients와 procedure은 리스트 형태기 때문에 Typeconverter로 저장
* */
@Entity("recipes")
data class RecipeEntity(
    val category: String,
    @PrimaryKey val id: Int,
    val name: String,
    val image: String,
    val chef: String,
    val time: String,
    val rating: Double,
    val filterTime: String,
    val isBookMarked: Int,
    val video: String,
    val ingredients: String,
    val procedure: String
)