package com.example.noteski20.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.noteski20.domain.NoticeItem
import com.example.noteski20.domain.NoticeItemRepository
import kotlin.random.Random

class NoticeItemRepositoryImpl: NoticeItemRepository {

    private val noticeListLD = MutableLiveData<List<NoticeItem>>()
    private val noticeList: MutableList<NoticeItem> = mutableListOf()
    private var autoIncrementId = 0

    init {
        for (i in 0 .. 50) {
            val item = NoticeItem(
                "Name $i",
                "description",
                "14:88\n19.04.2025",
                Random.nextBoolean())
            addNoticeItem(item)
        }
    }

    companion object {
        private var instance: NoticeItemRepositoryImpl? = null
        private val lock = Any()

        fun getInstance(): NoticeItemRepositoryImpl {
            instance?.let { return it }
            synchronized(lock) {
                instance?.let { return it }
                return NoticeItemRepositoryImpl().also {
                    instance = it
                }
            }
        }
    }
    override fun addNoticeItem(noticeItem: NoticeItem) {
        if (noticeItem.id == NoticeItem.UNDEFINED_ID) {
            noticeItem.id = autoIncrementId++
        }
        noticeList.add(noticeItem)
        updateList()
    }

    override fun editNoticeItem(noticeItem: NoticeItem) {
        val oldElement = getNoticeItem(noticeItem.id)
        noticeList[noticeList.indexOf(oldElement)] = noticeItem
        updateList()
    }

    override fun deleteNoticeItem(noticeItem: NoticeItem) {
        noticeList.remove(noticeItem)
        updateList()
    }

    override fun getNoticeItem(noticeItemId: Int): NoticeItem {
        return noticeList.find {
            it.id == noticeItemId
        } ?: throw RuntimeException("Element with $noticeItemId not found!")
    }

    override fun getNoticeList(): LiveData<List<NoticeItem>> {
        return noticeListLD
    }

    private fun updateList() {
        noticeListLD.value = noticeList.toList()
    }
}