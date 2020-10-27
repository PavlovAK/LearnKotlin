package lesson1_6

interface Photo {
    val id: Long
    val albumId: Long
    val ownerId: Long
    val userId: Long
    val text: String
    val date: Long
    val sizes: Array<Sizes>
    val width: Int?
    val heidth: Int?
}