package com.example.noteski20.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.noteski20.domain.NoteItem
import com.example.noteski20.domain.NoteItemRepository
import kotlin.random.Random

class NoteItemRepositoryImpl : NoteItemRepository {

    private val noteListLD = MutableLiveData<List<NoteItem>>()
    private val noteList: MutableList<NoteItem> = mutableListOf()
    private var autoIncrementId = 0

    init {
        for (i in 0..50) {
            val item = NoteItem(
                "Name $i",
                "description",
                "14:88\n19.04.2025",
                Random.nextBoolean()
            )
            addNoteItem(item)
        }
    }

    companion object {
        private var instance: NoteItemRepositoryImpl? = null
        private val lock = Any()

        fun getInstance(): NoteItemRepositoryImpl {
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }
                return NoteItemRepositoryImpl().also {
                    instance = it
                }
            }
        }
    }

    override fun addNoteItem(noteItem: NoteItem) {
        if (noteItem.id == NoteItem.UNDEFINED_ID) {
            noteItem.id = autoIncrementId++
        }
        noteList.add(noteItem)
        updateList()
    }

    override fun editNoteItem(noteItem: NoteItem) {
        val oldElement = getNoteItem(noteItem.id)
        noteList[noteList.indexOf(oldElement)] = noteItem
        updateList()
    }

    override fun deleteNoteItem(noteItem: NoteItem) {
        noteList.remove(noteItem)
        updateList()
    }

    override fun getNoteItem(noteItemId: Int): NoteItem {
        return noteList.find {
            it.id == noteItemId
        } ?: throw RuntimeException("Element with $noteItemId not found!")
    }

    override fun getNoteList(): LiveData<List<NoteItem>> {
        return noteListLD
    }

    private fun updateList() {
        noteListLD.value = noteList.toList()
    }
}