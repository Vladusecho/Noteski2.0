package com.example.noteski20.domain

data class NoticeItem(
    val name: String,
    val description: String,
    val dateTime: String,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}