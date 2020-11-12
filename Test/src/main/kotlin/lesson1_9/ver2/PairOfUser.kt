package lesson1_9.ver2

data class PairOfUsers(
    val user1: User,
    val user2: User
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PairOfUsers

        if(user1 == other.user1 && user2 == other.user2) return true
        if(user1 == other.user2 && user2 == other.user1) return true

        return false
    }

    override fun hashCode(): Int {
        return user1.hashCode() xor user2.hashCode()
    }
}

fun MutableList<PairOfUsers>.addPairOfUsers(userSender: User, userRecipient: User): Boolean {

    val pairOfUser = PairOfUsers(userSender, userRecipient)
    this
        .ifEmpty { return this.add(pairOfUser) }

    if (this.asSequence().contains(pairOfUser)) return false
    return this.add(pairOfUser)
}
