package lesson1_9.ver2

import org.junit.Test

import org.junit.Assert.*

internal class InMemoryChatServiceUpgradeTest {

    @Test
    fun createMessage_withoutChat() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        val result = chatServiceUpgrade.createMessage(userSender, userRecipient, text)

        assertTrue(result)
    }

    @Test
    fun createMessage_withChat() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        val result = chatServiceUpgrade.createMessage(userSender, userRecipient, text)

        assertTrue(result)
    }

    @Test
    fun deleteMessage_notLastMessageInChat() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        val result = chatServiceUpgrade.deleteMessage(1, 0)

        assertTrue(result)
    }

    @Test
    fun deleteMessage_lastMessageInChat() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.deleteMessage(1, 0)
        val result = chatServiceUpgrade.deleteMessage(1, 1)

        assertTrue(result)
    }

    @Test
    fun createChat_successCreate() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        val message = Message(
            0,
            0,
            0,
            text,
        false,
        false)
        val pairsOfUsers = chatServiceUpgrade.getPairsOfUsers()
        pairsOfUsers.addPairOfUsers(userSender, userRecipient)
        val result = chatServiceUpgrade.createChat(userSender, userRecipient, message)

        assertTrue(result)
    }

    @Test
    fun deleteChat_successDelete() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        val result = chatServiceUpgrade.deleteChat(1)

        assertTrue(result)
    }


    @Test
    fun getUnreadChats_allChatsIsDeleted() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.deleteChat(1)
        val result = chatServiceUpgrade.getUnreadChats()

        assertEquals(result, 0)
    }

    @Test
    fun readSomeMessagesInChat_readOneMessageFromTwo() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.readSomeMessagesInChat(1, 0, 1)
        val countOfUnreadMessages = chatServiceUpgrade.getAllChats().first { it.id == 1 }.messages.count { !it.isRead }
        val result = 1

        assertEquals(result, countOfUnreadMessages)
    }

    @Test
    fun readSomeMessagesInChat_readThreeMessageFromTwo() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.readSomeMessagesInChat(1, 0, 3)
        val countOfUnreadMessages = chatServiceUpgrade.getAllChats().first { it.id == 1 }.messages.count { !it.isRead }
        val result = 0

        assertEquals(result, countOfUnreadMessages)
    }

    @Test
    fun readAllMessagesInChat() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.readAllMessagesInChat(1)
        val countOfUnreadMessages = chatServiceUpgrade.getAllChats().first { it.id == 1 }.messages.count { !it.isRead }
        val result = 0

        assertEquals(result, countOfUnreadMessages)
    }

    @Test
    fun readChat() {

        val chatServiceUpgrade = InMemoryChatServiceUpgrade()
        val userSender = User(
            id = 0,
            firstName = "Ivan",
            secondName = "Ivanov"
        )
        val userRecipient = userSender.copy(id = 2)
        val text = "Hello"
        chatServiceUpgrade.createMessage(userSender, userRecipient, text)
        chatServiceUpgrade.readChat(1)
        val countOfUnreadChats = chatServiceUpgrade.getAllChats().count { !it.isRead }
        val result = 0

        assertEquals(result, countOfUnreadChats)
    }
}