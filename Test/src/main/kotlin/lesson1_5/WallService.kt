package lesson1_5

class WallService() {
        var posts = mutableListOf<Post>()

        fun addPost(post: Post): Post {
            val lastId = posts.lastOrNull()?.id ?: 0
            posts.add(post.copy(id = lastId + 1))
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

