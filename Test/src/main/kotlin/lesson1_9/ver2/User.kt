package lesson1_9.ver2

data class User(
    val id: Int,
    val firstName: String,
    val secondName: String,
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

fun MutableList<User>.addUser(user: User): Boolean {

    this
        .ifEmpty { return this.add(user) }

    if (this.contains(user)) return false
    return this.add(user)
}

fun MutableList<User>.removeUser(userId: Int): Boolean {

    this
        .ifEmpty { return false }
    this
        .remove(find { it.id == userId })

    return false
}

