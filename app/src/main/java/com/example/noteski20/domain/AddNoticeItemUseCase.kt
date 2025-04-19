package com.example.noteski20.domain

class AddNoticeItemUseCase(private val repository: NoticeItemRepository) {

    fun addNoticeItem(noticeItem: NoticeItem) {
        repository.addNoticeItem(noticeItem)
    }
}