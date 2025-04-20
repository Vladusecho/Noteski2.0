package com.example.noteski20.domain

class AddNoteItemUseCase(private val repository: NoteItemRepository) {

    fun addNoteItem(noteItem: NoteItem) {
        repository.addNoteItem(noteItem)
    }
}