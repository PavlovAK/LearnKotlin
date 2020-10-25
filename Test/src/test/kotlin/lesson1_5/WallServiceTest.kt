package lesson1_5

import org.junit.Test

import org.junit.Assert.*


internal class WallServiceTest {

    @Test
    fun addPost_notZero() {
        val wallService = WallService()
        var posts = mutableListOf<Post>()
        val firstView = Views(
            1
        )

        val firstRepost = Reposts(
            1,
            true
        )

        val firstComment = Comments(
            1,
            true,
            true,
            true,
            true
        )

        val firstPost = Post(
            0,
            1,
            1,
            1,
            1,
            "Post",
            1,
            1,
            true,
            firstComment,
            "PavlovAK",
            firstRepost,
            firstView,
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            1
        )

        val secondPost = firstPost.copy(id = 1)

        val targetValue = secondPost.id
        wallService.addPost(firstPost)
        val result = posts.get(0).id

        assertEquals(targetValue, result)
    }

    @Test
    fun updatePost_removePostWithId() {
        val wallService = WallService()
        val posts = mutableListOf<Post>()

        val firstView = Views(
            1
        )

        val firstRepost = Reposts(
            1,
            true
        )

        val firstComment = Comments(
            1,
            true,
            true,
            true,
            true
        )

        val firstPost = Post(
            0,
            1,
            1,
            1,
            1,
            "Post",
            1,
            1,
            true,
            firstComment,
            "PavlovAK",
            firstRepost,
            firstView,
            1,
            true,
            true,
            true,
            true,
            true,
            true,
            1
        )

        val secondPost = firstPost.copy (fromId = 999)
        posts.add(firstPost)
        wallService.addPost(secondPost)
        assertTrue(wallService.updatePost(secondPost))

    }
}