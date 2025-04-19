package com.example.noteski20.domain

import androidx.lifecycle.LiveData

interface NoticeItemRepository {

    fun addNoticeItem(noticeItem: NoticeItem)

    fun editNoticeItem(noticeItem: NoticeItem)

    fun deleteNoticeItem(noticeItem: NoticeItem)

    fun getNoticeItem(noticeItemId: Int): NoticeItem

    fun getNoticeList(): LiveData<List<NoticeItem>>
}