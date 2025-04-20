package com.example.noteski20.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.noteski20.R
import com.example.noteski20.domain.NoteItem

class NotesListAdapter : ListAdapter<NoteItem, NoteItemViewHolder>(NoteItemDiffCallback()) {

    var onNoteItemClickListener: ((NoteItem) -> Unit)? = null
    var onNoteItemLongClickListener: ((NoteItem) -> Unit)? = null

    companion object {
        const val ENABLED_LAYOUT = 1
        const val DISABLED_LAYOUT = -1
        const val MAX_POOL_SIZE = 20
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val layout = when (viewType) {
            ENABLED_LAYOUT -> R.layout.note_enabled
            DISABLED_LAYOUT -> R.layout.note_disabled
            else -> throw RuntimeException("Not found type of layout.")
        }
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return NoteItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnLongClickListener {
            onNoteItemLongClickListener?.invoke(item)
            true
        }
        holder.itemView.setOnClickListener {
            onNoteItemClickListener?.invoke(item)
        }
        holder.tvName.text = item.name
        holder.tvDesc.text = item.description
        holder.tvDate.text = item.dateTime
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) ENABLED_LAYOUT else DISABLED_LAYOUT
    }
}