package lesson1_6

data class AttachmentVideo(
    override val type: String = "video",
    val video: Video
): Attachment