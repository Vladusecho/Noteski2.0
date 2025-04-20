package com.example.noteski20.domain

class GetNoteItemUseCase(private val repository: NoteItemRepository) {

    fun getNoteItem(noticeItemId: Int): NoteItem {
        return repository.getNoteItem(noticeItemId)
    }
}