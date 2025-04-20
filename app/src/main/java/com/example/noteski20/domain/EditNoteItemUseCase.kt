package com.example.noteski20.domain

class EditNoteItemUseCase(private val repository: NoteItemRepository) {

    fun editNoteItem(noteItem: NoteItem) {
        repository.editNoteItem(noteItem)
    }
}