package lesson1_9

import org.junit.Test

import org.junit.Assert.*

internal class ChatServiceTest{

    @Test
    fun createMessage_withoutChat() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        chatService.userService.createPairOfUser(user, user2)
        val textOfMessage = "Hello"
        val result = chatService.createMessage(user, user2, textOfMessage)

        assertTrue(result is Chat)
    }

    @Test
    fun createMessage_withChat() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        val result = chatService.createMessage(user, user2, textOfMessage)

        assertTrue(result is Message)
    }

    @Test
    fun createChat_successCreate() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)

        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        val result = chatService.allChats.values.size

        assertEquals(result, 1)
    }

    @Test
    fun deleteMessage_notLastMessageInChat() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.deleteMessage(1, 1)
        val result = chatService.getCountDeletedMessages()

        assertEquals(result, 1)
    }

    @Test
    fun deleteMessage_LastMessageInChat() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.deleteMessage(1, 0)
        chatService.deleteMessage(1, 1)
        val result = chatService.getCountDeletedChats()
        assertEquals(result, 1)
    }

    @Test
    fun deleteChat_successDelete() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        val chat = chatService.allChats.values.last()
        chatService.deleteChat(chat)
        val result = chatService.getCountDeletedChats()
        assertEquals(result, 1)
    }

    @Test
    fun readAllMessagesInChat_successRead() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        val textOfMessage2 = "Hello2"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage2)
        chatService.createMessage(user, user2, textOfMessage2)
        val countOfUnreadMessages = chatService.readAllMessagesInChat(1)

        assertEquals(countOfUnreadMessages, 0)
    }

    @Test
    fun getUnreadChatCount() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        val textOfMessage2 = "Hello2"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage2)
        chatService.createMessage(user, user2, textOfMessage2)
        val result = chatService.getUnreadChatCount()

        assertEquals(result, 1)
    }

    @Test
    fun getChats_withText() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        val result = chatService.getChats()

        assertEquals(result, textOfMessage)
    }

    @Test
    fun getChats_withoutText() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        val chat = chatService.allChats.values
        for (chat in chat) {
            chat.messages.clear()
        }
        val exception = chatService.getChats()
        val textOfException = "Нет сообщений"

        assertEquals(exception, textOfException)
    }

    @Test
    fun getChats_exception101() {

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.allChats.values.clear()
        val exception = chatService.getChats()
        val textOfException = "Ошибка 101: Объект Message пуст"

        assertEquals(exception, textOfException)
    }

    @Test
    fun readSomeMessagesInChat_correctSize() {

        val chatIdCurrent = 1
        val messageIdLast = 1
        val countOfMessage = 2

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)

        assertTrue(chatService.readSomeMessagesInChat(chatIdCurrent, messageIdLast, countOfMessage))
    }

    @Test
    fun readSomeMessagesInChat_overSize() {

        val chatIdCurrent = 1
        val messageIdLast = 1
        val countOfMessage = 100

        val chatService = ChatService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val textOfMessage = "Hello"
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)
        chatService.createMessage(user, user2, textOfMessage)

        assertTrue(chatService.readSomeMessagesInChat(chatIdCurrent, messageIdLast, countOfMessage))
    }
}