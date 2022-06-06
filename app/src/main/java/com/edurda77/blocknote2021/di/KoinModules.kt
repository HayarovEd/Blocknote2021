package com.edurda77.blocknote2021.di

import androidx.room.Room
import com.edurda77.blocknote2021.data.DB_PATH
import com.edurda77.blocknote2021.repository.NoteDao
import com.edurda77.blocknote2021.repository.NoteRoomDb
import com.edurda77.blocknote2021.repository.RoomNoteRepoImpl
import com.edurda77.blocknote2021.ui.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModelModule = module {
    viewModel { NotesViewModel(get(),get()) }
}
val roomModule = module {
    single {
        Room.databaseBuilder(
            get(), NoteRoomDb::class.java,
            DB_PATH
        ).build()
    }
    single { get<NoteRoomDb>().noteDao() }
    fun provideUserRepositoryDb (noteDao: NoteDao): RoomNoteRepoImpl {
        return RoomNoteRepoImpl(noteDao)
    }
    single { provideUserRepositoryDb(get()) }
}



