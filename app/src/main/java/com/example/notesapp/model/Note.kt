package com.example.notesapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
/*
parcelization -
a mechanism that converts complex data objects
into a simple format that can be easily transferred
between activities or fragments
*/

data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val noteTitle : String,
    val noteDesc : String
): Parcelable

