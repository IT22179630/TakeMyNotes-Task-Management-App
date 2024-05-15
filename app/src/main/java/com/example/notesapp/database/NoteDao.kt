package com.example.notesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.model.Note

@Dao
interface NoteDao {
    //queries

    //insert query
    /* OnConflictStrategy -  a safe way to handle conflicts
    eg : if same primary key already exists in the table,
    then all the data will be replaced with the new data
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    //update query
    @Update
    suspend fun updateNote(note: Note)

    //delete query
    @Delete
    suspend fun deleteNote(note: Note)

    //to display the recently created note at the top
    @Query("SELECT * FROM NOTES ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    //search query
    @Query("SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteDesc LIKE :query")
    fun searchNote(query: String?): LiveData<List<Note>>
}