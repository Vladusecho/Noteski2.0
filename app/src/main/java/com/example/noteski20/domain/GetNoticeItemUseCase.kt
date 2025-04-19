package com.example.noteski20.domain

class GetNoticeItemUseCase(private val repository: NoticeItemRepository) {

    fun getNoticeItem(noticeItemId: Int): NoticeItem {
        return repository.getNoticeItem(noticeItemId)
    }
}