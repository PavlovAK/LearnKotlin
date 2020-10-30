package lesson1_8

data class Note(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val text: String,
    val date: Long,
    val comments: Int,
    val readComments: Int,
    val viewUrl: String,
    var remove: Boolean,
)