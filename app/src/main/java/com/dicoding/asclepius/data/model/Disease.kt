package com.dicoding.asclepius.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Disease(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = 0,

    @ColumnInfo(name = "image")
    val image: String? = null,

    @ColumnInfo(name = "label")
    val label: String? = null,

    @ColumnInfo(name = "confidenceScore")
    val confidenceScore: String? = null,
) : Parcelable
