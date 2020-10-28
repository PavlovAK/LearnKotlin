package lesson1_6

interface Audio{
    val id: Long
    val ownerId: Long
    val artist: String
    val title: String
    val duration: Int
    val url: String
    val lyricsId: Int
    val albumId: Int
    val genreId: Int
    val date: Long
    val noSearch: Boolean
    val isHq: Boolean
}