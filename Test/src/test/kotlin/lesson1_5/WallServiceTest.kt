package lesson1_5

import lesson1_5.WallService.posts
import org.junit.Test

import org.junit.Assert.*


internal class WallServiceTest {

    @Test
    fun addPost_notZero() {
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

        val targetValue = 1
        WallService.addPost(firstPost)
        val result = posts.get(0).id

        assertEquals(targetValue, result)
    }
}