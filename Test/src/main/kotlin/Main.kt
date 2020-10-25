import lesson1_2.discount
import lesson1_3.convertTime
import lesson1_5.*
import lesson1_5.WallService.posts

fun main() {

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
        1,
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

    val secondPost = firstPost.copy(ownerId = 100_000)
    val thirdPost = secondPost.copy(id = 1, fromId = 99999)


}