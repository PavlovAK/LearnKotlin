package lesson1_5

import lesson1_7.Comment
import lesson1_7.PostNotFoundException

class WallService() {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(comment: Comment): Boolean? {
        for (post in posts) {
            if(post.id == comment.postId) {
                comments += comment
                return true
            }
        }
        return throw PostNotFoundException("Не найден пост, к которому вы пишите комментарий")
    }

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

