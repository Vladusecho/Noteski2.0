package com.example.noteski20.domain

import androidx.lifecycle.LiveData

interface NoteItemRepository {

    fun addNoteItem(noteItem: NoteItem)

    fun editNoteItem(noteItem: NoteItem)

    fun deleteNoteItem(noteItem: NoteItem)

    fun getNoteItem(noteItemId: Int): NoteItem

    fun getNoteList(): LiveData<List<NoteItem>>
}