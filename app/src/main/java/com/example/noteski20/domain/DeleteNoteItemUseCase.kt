package com.example.noteski20.domain

class DeleteNoteItemUseCase(private val repository: NoteItemRepository) {

    fun deleteNoteItem(noteItem: NoteItem) {
        repository.deleteNoteItem(noteItem)
    }
}