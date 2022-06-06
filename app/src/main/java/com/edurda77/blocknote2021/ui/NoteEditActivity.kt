package com.edurda77.blocknote2021.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.edurda77.blocknote2021.R
import com.edurda77.blocknote2021.data.NoteModel
import com.edurda77.blocknote2021.databinding.ActivityEditNoteBinding
import com.edurda77.blocknote2021.repository.NoteDao


class NoteEditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditNoteBinding
    private lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NotesViewModel::class.java)

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
                Toast.makeText(this, "Заметка обновлена", Toast.LENGTH_SHORT).show()
            }
            binding.deleteNote.setOnClickListener {
                viewModel.deleteNote(note)
                initStartActivity()
                Toast.makeText(this, "Заметка удалена", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun initStartActivity() {
        val intent = Intent(this@NoteEditActivity, MainActivity::class.java)
        startActivity(intent)
    }




}