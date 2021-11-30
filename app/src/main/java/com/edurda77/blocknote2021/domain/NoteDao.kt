package com.edurda77.blocknote2021.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.edurda77.blocknote2021.data.*

@Dao
interface NoteDao {
    @Insert
    fun add(note: NoteModel)
    @Query("SELECT * FROM $NOTE_TABLE")
    fun getNots(): List<NoteModel>
    @Query("DELETE FROM $NOTE_TABLE WHERE $NOTE_ID=:id")
    fun delete (id: Int)
    @Query("UPDATE $NOTE_TABLE SET $NOTE_TITLE=:title,$NOTE_CONTENT=:content  WHERE $NOTE_ID=:id")
    fun update (id: Int, title: String, content: String)

}