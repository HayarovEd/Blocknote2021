package com.edurda77.Blocknote2021.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.Blocknote2021.R
import com.edurda77.Blocknote2021.data.NoteModel

class NoteHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_note, parent, false)) {

    private var titleNote: TextView? = null
    private var contentNote: TextView? = null

    init {
        titleNote = itemView.findViewById(R.id.title_note_view)
        contentNote = itemView.findViewById(R.id.content_note_view)

    }
    @SuppressLint("SetTextI18n")
    fun bind(note: NoteModel) {
        titleNote?.text =  note.titleNote
        contentNote?.text = note.contentNote
    }

}