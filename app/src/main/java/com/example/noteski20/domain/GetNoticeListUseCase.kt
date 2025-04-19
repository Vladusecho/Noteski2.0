package com.example.noteski20.domain

import androidx.lifecycle.LiveData

class GetNoticeListUseCase(private val repository: NoticeItemRepository) {

    fun getNoticeList(): LiveData<List<NoticeItem>> {
        return repository.getNoticeList()
    }
}