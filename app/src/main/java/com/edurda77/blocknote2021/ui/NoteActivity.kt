package com.edurda77.blocknote2021.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.edurda77.blocknote2021.R
import com.edurda77.blocknote2021.data.NoteModel
import com.edurda77.blocknote2021.databinding.ActivityEditNoteBinding
import com.edurda77.blocknote2021.databinding.ActivityNoteBinding
import com.edurda77.blocknote2021.domain.NoteDao

class NoteActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    private lateinit var binding: ActivityNoteBinding
    private val noteDao: NoteDao by lazy { app.noteDao }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNoteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setToolbar()
        val titleEditText: EditText = binding.titleNewNote
        val contentEditText: EditText = binding.contentNewNote
        binding.saveNewNote.setOnClickListener {
            val content = contentEditText.text.toString()
            val title = titleEditText.text.toString()
            val note = NoteModel(0,title,content)
            Thread {
                noteDao.add(note)
                runOnUiThread {
                    initStartActivity()
                }
            }.start()
            Toast.makeText(this,"Заметка добавлена", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initStartActivity() {
        val intent = Intent(this@NoteActivity, MainActivity::class.java)
        startActivity(intent)
    }
    private fun setToolbar() {
        toolbar = binding.toolbar
        setSupportActionBar(toolbar)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.new_note -> {
                val intent = Intent(this, NoteEditActivity::class.java)
                startActivity(intent)
            }
            R.id.custom -> {
                val intent = Intent(this, CustomActivity::class.java)
                startActivity(intent)
            }
            R.id.about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}