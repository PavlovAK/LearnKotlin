package lesson1_9.ver2

data class Chat(
    val id: Int,
    val date: Int,
    val messages: MutableList<Message>,
    val pairOfUser: PairOfUsers,
    var isRead: Boolean,
    var isDeleted: Boolean
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Chat

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

