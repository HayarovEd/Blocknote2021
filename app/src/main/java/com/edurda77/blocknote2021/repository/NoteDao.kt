package com.edurda77.blocknote2021.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.edurda77.blocknote2021.data.*

@Dao
interface NoteDao {
    @Insert
    suspend  fun add(note: NoteModel)
    @Query("SELECT * FROM $NOTE_TABLE")
    fun getNots(): LiveData<List<NoteModel>>
    @Query("DELETE FROM $NOTE_TABLE WHERE $NOTE_ID=:id")
    suspend fun delete (id: Int)
    @Query("UPDATE $NOTE_TABLE SET $NOTE_CONTENT=:content  WHERE $NOTE_ID=:id")
    suspend fun update (id: Int, content: String)

}