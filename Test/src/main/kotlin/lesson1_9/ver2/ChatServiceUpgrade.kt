package lesson1_9.ver2

interface ChatServiceUpgrade {

    fun createMessage(userSender: User, userRecipient: User, message: Message): Boolean
    fun deleteMessage(chatId: Int, messageId: Int): Boolean
    fun createChat(userSender: User, userRecipient: User, message: Message): Boolean
    fun deleteChat(chatId: Int): Boolean
    fun getChats()
    fun getUnreadChats(): Int
    fun readSomeMessagesInChat(chatId: Int, messageId: Int, countOfMessage: Int): Boolean
    fun readAllMessagesInChat(chatId: Int): Boolean
    fun readChat(chatId: Int): Boolean


}

class InMemoryChatServiceUpgrade() : ChatServiceUpgrade {
    private var allChats = mutableListOf<Chat>()
    private var pairsOfUsers = mutableListOf<PairOfUsers>()
    private var chatId = 0
    private var messageId = 0


    override fun createMessage(userSender: User, userRecipient: User, message: Message): Boolean {

        val resultOfAddingPairOfUser = pairsOfUsers.addPairOfUsers(userSender, userRecipient)
        if (resultOfAddingPairOfUser) {
            val message = Message(
                chatId = chatId,
                id = messageId,
                date = 0,
                text = "Hello",
                isRead = false,
                isDeleted = false
            )
            chatId++
            messageId++
            createChat(userSender, userRecipient, message)
            return true
        }
        allChats
            .first { it.id == message.chatId }
            .apply { this.messages.add(message) }
            .let { messageId++ }
            .also { return true }
    }

    override fun deleteMessage(chatId: Int, messageId: Int): Boolean {

        val currentMessages = allChats
            .first { it.id == chatId }.messages

        currentMessages
            .first { it.id == messageId }
            .apply { isDeleted = true }

        currentMessages
            .remove(currentMessages
                .first { it.id == messageId })

        currentMessages
            .ifEmpty { deleteChat(chatId) }

        return true
    }

    override fun createChat(userSender: User, userRecipient: User, message: Message): Boolean {
        val messagesForChat = mutableListOf<Message>()
        messagesForChat.add(message)
        val pairOfUsers = pairsOfUsers.last()
        val chat = Chat(
            id = message.chatId,
            date = 0,
            messages = messagesForChat,
            pairOfUser = pairOfUsers,
            isRead = false,
            isDeleted = false
        )
        return allChats.add(chat)
    }

    override fun deleteChat(chatId: Int): Boolean {

        allChats
            .first { it.id == chatId }
            .apply { isDeleted = true }

        return allChats
            .remove(allChats.first { it.id == chatId })
    }

    override fun getChats() {

        try {
            allChats
                .forEach { println(it.messages.last()) }
        } catch (e: Exception) {
            println("Нет сообщений")
        }
    }

    override fun getUnreadChats(): Int {

        return allChats
            .count { !it.isRead }
    }

    override fun readSomeMessagesInChat(chatId: Int, messageId: Int, countOfMessage: Int): Boolean {
        val messages = allChats.first { it.id == chatId }.messages
        val lastIndex = messages.lastIndex
        val indexFromRead = messages.indexOfFirst { it.id == messageId }
        val indexToRead = (indexFromRead + countOfMessage) + 1
        if (lastIndex <= indexToRead) {
            val messagesToRead = messages.subList(indexFromRead, lastIndex)
            readAllMessagesInChat(chatId)
            return messagesToRead.last().isRead
        }
        val messagesToRead = messages.subList(indexFromRead, indexToRead)
        for (message in messagesToRead) {
            message.apply { isRead = true }
        }
        return messagesToRead.last().isRead
    }

    override fun readAllMessagesInChat(chatId: Int): Boolean {

        allChats
            .first { it.id == chatId }
            .apply { isRead = true }
            .messages
            .forEach { it.isRead = true }

        return true
    }

    override fun readChat(chatIdFor: Int): Boolean {

        allChats
            .first { it.id == chatId }
            .apply { isRead = true }

        return true
    }
}
