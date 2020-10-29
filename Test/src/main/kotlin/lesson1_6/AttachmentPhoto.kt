package lesson1_6

data class AttachmentPhoto(
    override val type: String = "photo",
    val photo: Photo
): Attachment