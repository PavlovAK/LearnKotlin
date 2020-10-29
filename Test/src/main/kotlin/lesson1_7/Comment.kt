package lesson1_7

import lesson1_6.Attachment

data class Comment(
    val postId: Long,
    val id: Long,
    val fromId: Long,
    val date: Long,
    val text: String,
    val replyToUser: Long,
    val replyToComment: Long,
    val attachments: Attachment?,
    val parentsStack: Array<Long>,
    val thread: Thread
)