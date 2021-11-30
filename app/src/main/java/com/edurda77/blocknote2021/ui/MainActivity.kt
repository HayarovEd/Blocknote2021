package com.edurda77.blocknote2021.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.blocknote2021.R
import com.edurda77.blocknote2021.data.NoteModel
import com.edurda77.blocknote2021.databinding.ActivityMainBinding
import com.edurda77.blocknote2021.domain.NoteDao

class MainActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    private val noteDao: NoteDao by lazy { app.noteDao }
    private val notsOfMovie = emptyList<NoteModel>().toMutableList()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setToolbar()
        setRecycledView()
    }
    private fun setRecycledView() {
        val recyclerView: RecyclerView = binding.itemNoteView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager
            .VERTICAL, false)
        val nots=initNots()
        val stateClickListener: NoteAdapter.OnStateClickListener =
            object : NoteAdapter.OnStateClickListener {
                override fun onStateClick(note: NoteModel, position: Int) {
                    Thread {


                        runOnUiThread {
                            val intent = Intent(this@MainActivity, NoteEditActivity::class.java)
                            intent.putExtra(NoteModel::class.java.simpleName, note)

                            startActivity(intent)
                        }
                    }.start()
                }
            }
        recyclerView.adapter = NoteAdapter(nots,stateClickListener)
    }

    private fun initNots(): List<NoteModel> {
        Thread{
            noteDao.getNots().forEach {
                notsOfMovie.add(it)}
        }.start()

        return notsOfMovie
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun setToolbar() {
        toolbar = binding.toolbar
        setSupportActionBar(toolbar)

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