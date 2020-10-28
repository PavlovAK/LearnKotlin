package lesson1_6

interface Doc {
    val id: Long
    val ownerId: Long
    val title: String
    val size: Int
    val ext: String
    val url: String
    val date: Long
    val typeOfDoc: String
    val preview: Preview?
}