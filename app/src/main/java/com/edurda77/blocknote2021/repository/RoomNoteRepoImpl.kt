package com.edurda77.blocknote2021.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.edurda77.blocknote2021.data.DB_PATH
import com.edurda77.blocknote2021.data.NoteModel



class RoomNoteRepoImpl(private val noteDao: NoteDao) : NoteDao {


    override suspend fun add(note: NoteModel) {
        noteDao.add(note)

    }

    override fun getNotes(): LiveData<List<NoteModel>> {
        return noteDao.getNotes()
    }

    override suspend fun delete(id: Int) {
        noteDao.delete(id)
    }

    override suspend fun update(id: Int, content: String) {
        noteDao.update(id, content)
    }
}