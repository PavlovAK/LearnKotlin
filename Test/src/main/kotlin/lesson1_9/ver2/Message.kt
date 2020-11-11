package lesson1_9.ver2

data class Message(
    val chatId: Int,
    val id: Int,
    val date: Int,
    val text: String,
    var isRead: Boolean,
    var isDeleted: Boolean
)