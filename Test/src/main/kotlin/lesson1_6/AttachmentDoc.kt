package lesson1_6

data class AttachmentDoc(
    override val type: String = "doc",
    val doc: Doc
): Attachment