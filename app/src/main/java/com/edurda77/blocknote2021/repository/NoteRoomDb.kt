package com.edurda77.blocknote2021.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edurda77.blocknote2021.data.NoteModel
import com.edurda77.blocknote2021.repository.NoteDao

@Database(
    entities = [NoteModel:: class],
    version = 1
)
abstract class NoteRoomDb : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}