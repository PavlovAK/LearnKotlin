package lesson1_5

import org.junit.Test

import org.junit.Assert.*


internal class WallServiceTest {

    @Test
    fun addPost_notZero() {
        val wallService = WallService()
        val firstView = Views(
            1
        )
        val firstRepost = Reposts(
            1,
            true
        )
        val firstComment = Comments(
            count = 1,
            canPost = true,
            groupsCanPost = true,
            canClose = true,
            canOpen = true
        )
        val firstPost = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 1,
            text = "Post",
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = true,
            comments = firstComment,
            copyright = "PavlovAK",
            reposts = firstRepost,
            views = firstView,
            signerId = 1,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 1
        )
        val secondPost = firstPost.copy(id = 1)
        val result = wallService.addPost(firstPost)
        assertEquals(secondPost, result)
    }

    @Test
    fun updatePost_removePostWithId() {
        val wallService = WallService()
        val firstView = Views(
            1
        )
        val firstRepost = Reposts(
            1,
            true
        )
        val firstComment = Comments(
            count = 1,
            canPost = true,
            groupsCanPost = true,
            canClose = true,
            canOpen = true
        )
        val firstPost = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 1,
            text = "Post",
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = true,
            comments = firstComment,
            copyright = "PavlovAK",
            reposts = firstRepost,
            views = firstView,
            signerId = 1,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 1
        )
        val secondPost = wallService.addPost(firstPost)
        assertTrue(wallService.updatePost(secondPost))
    }

    @Test
    fun updatePost_removePostWithotId() {
        val wallService = WallService()
        val firstView = Views(
            1
        )
        val firstRepost = Reposts(
            1,
            true
        )
        val firstComment = Comments(
            count = 1,
            canPost = true,
            groupsCanPost = true,
            canClose = true,
            canOpen = true
        )
        val firstPost = Post(
            id = 0,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 1,
            text = "Post",
            replyOwnerId = 1,
            replyPostId = 1,
            friendsOnly = true,
            comments = firstComment,
            copyright = "PavlovAK",
            reposts = firstRepost,
            views = firstView,
            signerId = 1,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 1
        )

        assertFalse(wallService.updatePost(firstPost))
    }
}