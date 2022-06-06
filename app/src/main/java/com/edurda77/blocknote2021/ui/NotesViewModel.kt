package com.edurda77.blocknote2021.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.edurda77.blocknote2021.data.NoteModel
import com.edurda77.blocknote2021.repository.RoomNoteRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    private val caseRepoImpl: RoomNoteRepoImpl
    val liveData: LiveData<List<NoteModel>>

    init {
        caseRepoImpl = RoomNoteRepoImpl(application.applicationContext)
        liveData = caseRepoImpl.getNots()
    }

    fun deleteNote(note: NoteModel) = viewModelScope.launch(Dispatchers.IO) {
        caseRepoImpl.delete(note.idNote)
    }

    fun updateNote(note: NoteModel) = viewModelScope.launch(Dispatchers.IO) {
        caseRepoImpl.update(note.idNote, note.contentNote)
    }

    fun addNote(note: NoteModel) = viewModelScope.launch(Dispatchers.IO) {
        caseRepoImpl.add(note)
    }
}