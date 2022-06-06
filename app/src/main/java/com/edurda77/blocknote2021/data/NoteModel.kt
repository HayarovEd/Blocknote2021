package com.edurda77.blocknote2021.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable



@Entity(tableName = NOTE_TABLE)
data class NoteModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = NOTE_ID)
    val idNote: Int,
    @ColumnInfo(name = NOTE_CONTENT)
    val contentNote: String

) : Serializable
