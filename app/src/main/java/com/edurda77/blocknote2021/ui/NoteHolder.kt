package com.edurda77.blocknote2021.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.blocknote2021.R
import com.edurda77.blocknote2021.data.NoteModel

class NoteHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_note, parent, false)) {

    private var contentNote: TextView? = itemView.findViewById(R.id.content_note_view)

    fun bind(note: NoteModel) {
        contentNote?.text = note.contentNote
    }

}