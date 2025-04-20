package com.example.noteski20.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteski20.R

class NoteItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tv_note_name)
    val tvDate = view.findViewById<TextView>(R.id.tv_note_date)
    val tvDesc = view.findViewById<TextView>(R.id.tv_note_about)
}