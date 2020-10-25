package lesson1_5

data class Likes(
    val count: Int,
    val userLike: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)