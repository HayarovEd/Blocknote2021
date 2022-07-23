package com.edurda77.blocknote2021.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.edurda77.blocknote2021.data.DELETE_NOTE
import com.edurda77.blocknote2021.data.NoteModel
import com.edurda77.blocknote2021.data.UPDATE_NOTE
import com.edurda77.blocknote2021.databinding.ActivityEditNoteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class NoteEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditNoteBinding
    //private lateinit var viewModel: NotesViewModel
    private val viewModel: NotesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
       /* viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NotesViewModel::class.java]*/

        val arguments = intent.extras
        val note: NoteModel

        if (arguments != null) {
            note = arguments.getSerializable(NoteModel::class.java.simpleName) as NoteModel

            binding.contentNote.setText(note.contentNote)


            binding.saveNote.setOnClickListener {
                val content = binding.contentNote.text.toString()
                val updateNote = NoteModel (note.idNote, content)
                viewModel.updateNote(updateNote)
                initStartActivity()
                Toast.makeText(this, UPDATE_NOTE, Toast.LENGTH_SHORT).show()
            }
            binding.deleteNote.setOnClickListener {
                viewModel.deleteNote(note)
                initStartActivity()
                Toast.makeText(this, DELETE_NOTE, Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun initStartActivity() {
        val intent = Intent(this@NoteEditActivity, MainActivity::class.java)
        startActivity(intent)
    }




}