package com.dicoding.asclepius.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.asclepius.data.model.Disease

@Database(entities = [Disease::class], version = 1)
abstract class DiseaseRoomDatabase : RoomDatabase()