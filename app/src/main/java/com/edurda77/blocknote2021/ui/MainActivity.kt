package com.edurda77.blocknote2021.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.blocknote2021.R
import com.edurda77.blocknote2021.data.NoteModel
import com.edurda77.blocknote2021.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NoteClickDeleteInterface {
    private lateinit var viewModel: NotesViewModel

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAddNewNote()
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[NotesViewModel::class.java]
        viewModel.liveData.observe(this) {
            setRecycledView(it)
        }

    }

    private fun setRecycledView(notes: List<NoteModel>) {
        val recyclerView: RecyclerView = binding.itemNoteView
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager
                .VERTICAL, false
        )

        val stateClickListener: NoteAdapter.OnStateClickListener =
            object : NoteAdapter.OnStateClickListener {
                override fun onStateClick(note: NoteModel, position: Int) {
                    val intent = Intent(this@MainActivity, NoteEditActivity::class.java)
                    intent.putExtra(NoteModel::class.java.simpleName, note)

                    startActivity(intent)
                }

            }
        recyclerView.adapter = NoteAdapter(notes, stateClickListener, this)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun setAddNewNote() {
        binding.addNewNote.setOnClickListener {
            val intent = Intent(this, NoteActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onDeleteIconClick(note: NoteModel) {
        viewModel.deleteNote(note)
    }


}