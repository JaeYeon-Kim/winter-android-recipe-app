package com.surivalcoding.composerecipeapp.di

import android.content.Context
import androidx.room.Room
import com.surivalcoding.composerecipeapp.data.database.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRecipeDataBase(@ApplicationContext context: Context): RecipeDatabase =
        Room.databaseBuilder(context, RecipeDatabase::class.java, "recipe.db")
            .build()

    @Singleton
    @Provides
    fun provideRecipeDao(recipeDatabase: RecipeDatabase) = recipeDatabase.recipeDao()
}