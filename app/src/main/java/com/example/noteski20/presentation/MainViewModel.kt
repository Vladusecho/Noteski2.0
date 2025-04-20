package com.example.noteski20.presentation

import androidx.lifecycle.ViewModel
import com.example.noteski20.data.NoteItemRepositoryImpl
import com.example.noteski20.domain.DeleteNoteItemUseCase
import com.example.noteski20.domain.EditNoteItemUseCase
import com.example.noteski20.domain.GetNoteListUseCase
import com.example.noteski20.domain.NoteItem

class MainViewModel : ViewModel() {

    private val repository = NoteItemRepositoryImpl.getInstance()

    private val getNoteListUseCase = GetNoteListUseCase(repository)
    private val deleteNoteItemUseCase = DeleteNoteItemUseCase(repository)
    private val editNoteItemUseCase = EditNoteItemUseCase(repository)

    val noteList = getNoteListUseCase.getNoteList()

    fun deleteNoteItem(noteItem: NoteItem) {
        deleteNoteItemUseCase.deleteNoteItem(noteItem)
    }

    fun changeStateItem(noteItem: NoteItem) {
        val newItem = noteItem.copy(enabled = !noteItem.enabled)
        editNoteItemUseCase.editNoteItem(newItem)
    }
}