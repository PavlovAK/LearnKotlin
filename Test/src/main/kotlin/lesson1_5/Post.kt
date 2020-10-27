package lesson1_5

import lesson1_6.Attachment
import lesson1_6.Geo
import lesson1_6.PostSourse

data class Post(
    val id: Long,
    val ownerId: Long,
    var fromId: Long,
    val createdBy: Long,
    val date: Long,
    val text: String,
    val replyOwnerId: Long,
    val replyPostId: Long,
    val friendsOnly: Boolean,
    val comments: Comments?,
    val copyright: String,
    val reposts: Reposts,
    val views: Views?,
    val postType: String,
    val postSourse: PostSourse,
    val attachments: Array<Attachment>?,
    val geo: Geo?,
    val copyHistory: Array<Post>?,
    val signerId: Long,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Long
)

