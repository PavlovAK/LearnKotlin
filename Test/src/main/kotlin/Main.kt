
import lesson1_9.ver2.InMemoryChatServiceUpgrade
import lesson1_9.ver2.User

fun main() {

    val chatServiceUpgrade = InMemoryChatServiceUpgrade()
    val userSender = User(
        id = 0,
        firstName = "Ivan",
        secondName = "Ivanov"
    )
    val userRecipient = userSender.copy(id = 2)
    val text = "Hello"
    val result = chatServiceUpgrade.createMessage(userSender, userRecipient, text)

    println(result)
}