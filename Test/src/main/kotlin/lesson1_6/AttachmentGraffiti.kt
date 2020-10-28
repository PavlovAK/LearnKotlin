package lesson1_6

class AttachmentGraffiti(
    override val type: String,
    override val id: Long,
    override val ownerId: Long,
    override val photo130: String,
    override val photo604: String
): Attachment, Graffiti