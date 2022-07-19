package com.study.mvvm.marvelappstarter.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.study.mvvm.marvelappstarter.data.model.character.CharacterModel

@Database(entities = [CharacterModel::class], version = 1, exportSchema = false)

@TypeConverters(MarvelConverters::class)
abstract class MarvelDataBase : RoomDatabase() {
    abstract fun marvelDao(): MarvelDao
}