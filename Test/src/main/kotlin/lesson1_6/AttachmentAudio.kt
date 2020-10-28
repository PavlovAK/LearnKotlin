package lesson1_6

class AttachmentAudio(
    override val type: String = "audio",
    override val id: Long,
    override val ownerId: Long,
    override val artist: String,
    override val title: String,
    override val duration: Int,
    override val url: String,
    override val lyricsId: Int,
    override val albumId: Int,
    override val genreId: Int,
    override val date: Long,
    override val noSearch: Boolean,
    override val isHq: Boolean
): Attachment, Audio