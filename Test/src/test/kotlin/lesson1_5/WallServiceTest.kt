package lesson1_5

import lesson1_6.Attachment
import lesson1_6.Geo
import lesson1_6.Place
import lesson1_6.PostSourse
import org.junit.Test

import org.junit.Assert.*


internal class WallServiceTest {

    @Test
    fun addPost_notZero() {

        val wallService = WallService()

        val attachments = emptyArray<Attachment>()

        val copyHistory = emptyArray<Post>()

        val firstPlace = Place(
            id = 100,
            title = "House of Kolotushkina",
            latitude = 14,
            longitude = 88,
            created = 23456,
            icon = "Picture",
            checkins = 1,
            updated = 3454,
            type = 7,
            country = 7,
            city = 77,
            addres = "Moscow"
        )

        val firstGeo = Geo(
            type = "country",
            coordinates = "Pushkina street",
            place = firstPlace
        )

        val firstPostSource = PostSourse(
            type = "vk",
            platform = "android",
            data = "like",
            url = "www.leningrad.ru"
        )

        val firstView = Views(1)

        val firstRepost = Reposts(
            count = 1,
            userReposted = true
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
            postType = "post",
            postSourse = firstPostSource,
            attachments = attachments,
            geo = firstGeo,
            signerId = 1,
            copyHistory = copyHistory,
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

        val attachments = emptyArray<Attachment>()

        val copyHistory = emptyArray<Post>()

        val firstPlace = Place(
            id = 100,
            title = "House of Kolotushkina",
            latitude = 14,
            longitude = 88,
            created = 23456,
            icon = "Picture",
            checkins = 1,
            updated = 3454,
            type = 7,
            country = 7,
            city = 77,
            addres = "Moscow"
        )

        val firstGeo = Geo(
            type = "country",
            coordinates = "Pushkina street",
            place = firstPlace
        )

        val firstPostSource = PostSourse(
            type = "vk",
            platform = "android",
            data = "like",
            url = "www.leningrad.ru"
        )

        val firstView = Views(1)

        val firstRepost = Reposts(
            count = 1,
            userReposted = true
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
            postType = "post",
            postSourse = firstPostSource,
            attachments = attachments,
            geo = firstGeo,
            signerId = 1,
            copyHistory = copyHistory,
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

        val attachments = emptyArray<Attachment>()

        val copyHistory = emptyArray<Post>()

        val firstPlace = Place(
            id = 100,
            title = "House of Kolotushkina",
            latitude = 14,
            longitude = 88,
            created = 23456,
            icon = "Picture",
            checkins = 1,
            updated = 3454,
            type = 7,
            country = 7,
            city = 77,
            addres = "Moscow"
        )

        val firstGeo = Geo(
            type = "country",
            coordinates = "Pushkina street",
            place = firstPlace
        )

        val firstPostSource = PostSourse(
            type = "vk",
            platform = "android",
            data = "like",
            url = "www.leningrad.ru"
        )

        val firstView = Views(1)

        val firstRepost = Reposts(
            count = 1,
            userReposted = true
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
            postType = "post",
            postSourse = firstPostSource,
            attachments = attachments,
            geo = firstGeo,
            signerId = 1,
            copyHistory = copyHistory,
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