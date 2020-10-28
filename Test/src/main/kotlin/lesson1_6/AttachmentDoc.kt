package lesson1_6

data class AttachmentDoc(
    override val type: String = "doc",
    override val id: Long,
    override val ownerId: Long,
    override val title: String,
    override val size: Int,
    override val ext: String,
    override val url: String,
    override val date: Long,
    override val typeOfDoc: String,
    override val preview: Preview?
): Attachment, Doc