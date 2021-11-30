package com.edurda77.Blocknote2021.ui

import android.app.Application
import android.content.Context
import com.edurda77.Blocknote2021.data.RoomNoteRepoImpl
import com.edurda77.Blocknote2021.domain.NoteDao

class App : Application() {
    val noteDao: NoteDao by lazy { RoomNoteRepoImpl(this) }
}

val Context.app
    get() = applicationContext as App