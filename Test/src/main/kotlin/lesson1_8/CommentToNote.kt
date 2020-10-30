package lesson1_8

import lesson1_6.Attachment

data class CommentToNote(
    val noteId: Long,
    val id: Long,
    val fromId: Long,
    val date: Long,
    val text: String,
    val replyToUser: Long,
    val replyToComment: Long,
    val attachments: Attachment?,
    val parentsStack: Array<Long>,
    var remove: Boolean
)