package com.edurda77.blocknote2021.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


const val NOTE_TABLE = "notes"
const val NOTE_ID = "id"
const val NOTE_TITLE = "title"
const val NOTE_CONTENT = "content"
@Entity(tableName = NOTE_TABLE)
data class NoteModel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = NOTE_ID)
    val idNote: Int,
    @ColumnInfo(name = NOTE_TITLE)
    val titleNote: String,
    @ColumnInfo(name = NOTE_CONTENT)
    val contentNote: String

) : Serializable
/*{
    companion object {
        const val  UNDEFINED_ID=-1
    }
}*/