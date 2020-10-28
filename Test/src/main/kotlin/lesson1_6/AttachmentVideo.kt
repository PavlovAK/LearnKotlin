package lesson1_6

data class AttachmentVideo(
    override val type: String = "video",
    override val id: Long,
    override val ownerId: Long,
    override val title: String,
    override val description: String,
    override val duration: Int,
    override val image: Array<Image>,
    override val firstFrame: Array<FirstFrame>,
    override val date: Long,
    override val addingDate: Long,
    override val views: Int,
    override val localViews: Int,
    override val comments: Int,
    override val player: String,
    override val canAdd: Boolean,
    override val isPrivate: Boolean,
    override val accessKey: String,
    override val processing: Boolean,
    override val isFavorite: Boolean,
    override val canComment: Boolean,
    override val canEdit: Boolean,
    override val canLike: Boolean,
    override val canRepost: Boolean,
    override val canSubscribe: Boolean,
    override val canAddToFaves: Boolean,
    override val canAttachLink: Boolean,
    override val width: Int,
    override val height: Int,
    override val userId: Int,
    override val converting: Boolean,
    override val added: Boolean,
    override val isSubscribed: Boolean,
    override val repeat: Boolean,
    override val typeOfVideo: String,
    override val balance: Int,
    override val liveStatus: String,
    override val live: Boolean,
    override val upcoming: Boolean,
    override val spectators: Int,
    override val likes: LikesForVideo,
    override val reposts: RepostsForVideo
): Attachment, Video