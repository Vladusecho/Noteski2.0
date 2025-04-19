package com.example.noteski20.domain

class DeleteNoticeItemUseCase(private val repository: NoticeItemRepository) {

    fun deleteNoticeItem(noticeItem: NoticeItem) {
        repository.deleteNoticeItem(noticeItem)
    }
}