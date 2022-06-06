package com.edurda77.blocknote2021.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.blocknote2021.R
import com.edurda77.blocknote2021.data.NoteModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_note, parent, false)) {

    val onDeleteClick: FloatingActionButton = itemView.findViewById(R.id.delete_note)
    private var contentNote: TextView? = itemView.findViewById(R.id.content_note_view)


    fun bind(note: NoteModel) {
        contentNote?.text = note.contentNote

    }

}