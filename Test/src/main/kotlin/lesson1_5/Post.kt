package lesson1_5

data class Post(
    var id: Long,
    val ownerId: Long,
    var fromId: Long,
    val createdBy: Long,
    val date: Long,
    val text: String,
    val replyOwnerId: Long,
    val replyPostId: Long,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: String,
    val reposts: Reposts,
    val views: Views,
    val signerId: Long,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Long
)

object WallService {
    var posts = emptyArray<Post>()

    fun addPost(post: Post): Post {
        val lastId = posts.lastOrNull()?.id ?: 0
        posts += post.copy(id = lastId + 1)
        return posts.last()
    }

    fun updatePost(post: Post): Boolean {
        val oldPost = posts.find { it.id == post.id } ?: return false
        val oldPostIndex = posts.indexOf(oldPost)
        val newPost = post.copy(date = oldPost.date, ownerId = oldPost.ownerId)
        posts[oldPostIndex] = newPost

        return true
    }
}
