package lesson1_9

data class Chat(
    val id: Int,
    val pairOfUser: PairOfUser,
    val messages: MutableList<Message>,
    val date: Int,
    var isRead: Boolean,
    var isDeleted: Boolean
)