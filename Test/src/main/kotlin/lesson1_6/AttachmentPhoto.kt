package lesson1_6

data class AttachmentPhoto(
    override val type: String = "photo",
    override val id: Long,
    override val albumId: Long,
    override val ownerId: Long,
    override val userId: Long,
    override val text: String,
    override val date: Long,
    override val sizes: Array<Sizes>,
    override val width: Int?,
    override val heidth: Int?
): Attachment, Photo