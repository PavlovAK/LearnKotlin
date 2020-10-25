import lesson1_2.discount
import lesson1_3.convertTime
import lesson1_5.*

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

    val secondPost = firstPost.copy (id = 2)

//    WallService.addPost(firstPost)
//    WallService.addPost(secondPost)
////    val targetIndex: Int = posts.indexOf(firstPost)
////    val targetId: Long = posts.get(targetIndex).id
//    val targetId = posts.get(posts.indexOf(secondPost)).id
//    val sizeBeforeRemove = posts.size
//    println(posts.remove(posts.fil))
//    val sizeAfterRemove = posts.size
//    println(posts.removeAt(0))
//    println(posts.toString())
}