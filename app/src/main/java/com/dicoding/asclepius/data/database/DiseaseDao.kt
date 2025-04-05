package com.dicoding.asclepius.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dicoding.asclepius.data.model.Disease

@Dao
interface DiseaseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(disease: Disease)

    @Update
    fun update(disease: Disease)

    @Delete
    fun delete(disease: Disease)

    @Query("SELECT * from disease ORDER BY id ASC")
    fun getAllDisease(): LiveData<List<Disease>>
}