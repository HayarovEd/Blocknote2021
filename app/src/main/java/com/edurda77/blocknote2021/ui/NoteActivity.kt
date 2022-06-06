package com.edurda77.blocknote2021.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.edurda77.blocknote2021.data.ADD_NOTE
import com.edurda77.blocknote2021.data.NoteModel
import com.edurda77.blocknote2021.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteBinding
    private lateinit var viewModel: NotesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNoteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NotesViewModel::class.java]
        binding.saveNewNote.setOnClickListener {
            val content = binding.contentNewNote.text.toString()
            val note = NoteModel(0, content)
            viewModel.addNote(note)
            initStartActivity()
            Toast.makeText(this, ADD_NOTE, Toast.LENGTH_SHORT).show()
        }

    }

    private fun initStartActivity() {
        val intent = Intent(this@NoteActivity, MainActivity::class.java)
        startActivity(intent)
    }




}