package lesson1_9

data class Message(
    val chatId: Int,
    val id: Int,
    val ownerId: Int,
    val date: Int,
    val text: String,
    var isRead: Boolean,
    var isDeleted: Boolean
)