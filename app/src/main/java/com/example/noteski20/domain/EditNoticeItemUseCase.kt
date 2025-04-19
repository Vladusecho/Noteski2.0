package com.example.noteski20.domain

class EditNoticeItemUseCase(private val repository: NoticeItemRepository) {

    fun editNoticeItem(noticeItem: NoticeItem) {
        repository.editNoticeItem(noticeItem)
    }
}