package lesson1_9.ver2

interface ChatServiceUpgrade {

    fun createMessage(userSender: User, userRecipient: User, text: String): Boolean
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
    private val allChats = mutableListOf<Chat>()
    private val pairsOfUsers = mutableListOf<PairOfUsers>()
    private var chatId = if (allChats.size == 0) 1 else allChats.last().id + 1
    private var messageId = 0


    override fun createMessage(userSender: User, userRecipient: User, text: String): Boolean {

        val message = Message(
            chatId = chatId,
            id = messageId,
            date = 0,
            text = text,
            isRead = false,
            isDeleted = false
        )
        val resultOfAddingPairOfUser = pairsOfUsers.addPairOfUsers(userSender, userRecipient)
        if (resultOfAddingPairOfUser) {
            chatId++
            messageId++
            createChat(userSender, userRecipient, message)
            return true
        }

        val currentPairOfUsers = PairOfUsers(userSender, userRecipient)
        messageId++

        return allChats
            .asSequence()
            .first { it.pairOfUser == currentPairOfUsers }
            .messages
            .add(message)
    }

    override fun deleteMessage(chatId: Int, messageId: Int): Boolean {

        val currentMessages = allChats
            .asSequence()
            .first { it.id == chatId }.messages

        currentMessages
            .asSequence()
            .first { it.id == messageId }
            .apply { isDeleted = true }

        currentMessages
            .remove(currentMessages
                .asSequence()
                .first { it.id == messageId })

        currentMessages
            .ifEmpty { deleteChat(chatId) }

        return true
    }

    override fun createChat(userSender: User, userRecipient: User, message: Message): Boolean {

            val pairOfUsers = pairsOfUsers.last()
            val messages = mutableListOf<Message>()
            messages.add(message)
            val chat = Chat(
                id = message.chatId,
                date = 0,
                messages = messages,
                pairOfUser = pairOfUsers,
                isRead = false,
                isDeleted = false
            )
            return allChats.add(chat)
    }

    override fun deleteChat(chatId: Int): Boolean {

        allChats
            .asSequence()
            .first { it.id == chatId }
            .apply { isDeleted = true }

        pairsOfUsers
            .remove(allChats
                .asSequence()
                .first { it.id == chatId }
                .pairOfUser)

        return allChats
            .remove(allChats
                .asSequence()
                .first { it.id == chatId })
    }

    override fun getChats() {

        allChats
            .forEach {
                it.messages.ifEmpty { println("Нет сообщений") }
                println(it.messages.last()) }
    }

    override fun getUnreadChats(): Int {

        return allChats
            .count { !it.isRead }
    }

    override fun readSomeMessagesInChat(chatId: Int, messageId: Int, countOfMessage: Int): Boolean {
        val messages = allChats.first { it.id == chatId }.messages
        val lastIndex = messages.lastIndex + 1
        val indexFromRead = messages.indexOfFirst { it.id == messageId }
        val indexToRead = indexFromRead + countOfMessage
        if (lastIndex <= indexToRead) {
            val messagesToRead = messages.subList(indexFromRead, lastIndex)
            messagesToRead.forEach {
                it.isRead = true }
            return messagesToRead.last().isRead
        }
        val messagesToRead = messages.subList(indexFromRead, indexToRead)
        messagesToRead.forEach {
            it.isRead = true }
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

    override fun readChat(chatId: Int): Boolean {

        allChats
            .asSequence()
            .first { it.id == chatId }
            .apply { isRead = true }

        return true
    }

    fun getPairsOfUsers(): MutableList<PairOfUsers> {
        return pairsOfUsers
    }

    fun getAllChats(): MutableList<Chat> {
        return allChats
    }
}
