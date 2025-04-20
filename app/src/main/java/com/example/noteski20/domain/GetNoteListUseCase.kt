package com.example.noteski20.domain

import androidx.lifecycle.LiveData

class GetNoteListUseCase(private val repository: NoteItemRepository) {

    fun getNoteList(): LiveData<List<NoteItem>> {
        return repository.getNoteList()
    }
}