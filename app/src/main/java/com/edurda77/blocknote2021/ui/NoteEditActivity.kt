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
import com.edurda77.blocknote2021.domain.NoteDao


class NoteEditActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    private lateinit var binding: ActivityEditNoteBinding
    private val noteDao: NoteDao by lazy { app.noteDao }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditNoteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setToolbar()
        val titleEditText: EditText = binding.titleNote
        val contentEditText: EditText = binding.contentNote


        val arguments = intent.extras
        val note: NoteModel

        if (arguments != null) {
            note = arguments.getSerializable(NoteModel::class.java.simpleName) as NoteModel

            var content = note.contentNote
            var title = note.titleNote
            val id = note.idNote
            titleEditText.setText(title)
            contentEditText.setText(content)


            binding.saveNote.setOnClickListener {
                content = binding.contentNote.text.toString()
                title = binding.titleNote.text.toString()
                Toast.makeText(this,content,Toast.LENGTH_LONG).show()
                Thread {
                    noteDao.update(id, title, content)
                    runOnUiThread {
                        initStartActivity()
                    }
                }.start()
                Toast.makeText(this,"Заметка обновлена",Toast.LENGTH_SHORT).show()
            }
            binding.deleteNote.setOnClickListener {


                Thread {
                    noteDao.delete(id)
                    runOnUiThread {
                        initStartActivity()
                    }

                }.start()
                Toast.makeText(this,"Заметка удалена",Toast.LENGTH_SHORT).show()
            }
        }


    }
    private fun initStartActivity() {
        val intent = Intent(this@NoteEditActivity, MainActivity::class.java)
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
                val intent = Intent(this, NoteActivity::class.java)
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