package lesson1_9

class ChatService() {

    val allChats = mutableMapOf<Int, Chat>()
    val userService = UserService()
    private var chatId = 0
    private var messageId = 0
    private var deletedMessages = 0
    private var deletedChats = 0

    fun createChat(pairOfUser: PairOfUser, message: Message): Chat {
        val chatMessages = mutableListOf<Message>()
        chatMessages.add(message)
        val chatIdCurrentId = getChatId()
        allChats[chatIdCurrentId] = Chat(chatIdCurrentId, pairOfUser, chatMessages, 0, false, false)
        return allChats.values.last()
    }

    fun createMessage(userTo: User, userFrom: User, textOfMessage: String): Any {
        val chatIdCurrent = getChatId()
        val messageIdCurrent = getMessageId()
        val message = Message(chatIdCurrent, messageIdCurrent, userFrom.id, 0, textOfMessage, false, false)
        val isChated = allChats.containsKey(chatIdCurrent)
        if(isChated){
            val chat = allChats.values.find { it.id == chatIdCurrent }
            chat?.messages?.add(message)
            messageId++
            return message
        }
        val pairOfUser = userService.createPairOfUser(userFrom, userTo)
        messageId++
        chatId++
        return createChat(pairOfUser, message)
    }

    fun deleteMessage(chatIdCurrent: Int, messageIdCurrent: Int): Boolean {
        val chat = allChats[chatIdCurrent]
        val listOfMessages = chat?.messages
        val message = listOfMessages?.find { it.id == messageIdCurrent }
        message?.isDeleted = true
        listOfMessages?.remove(message)
        deletedMessages++
        val listOfMessagesIsEmpty = listOfMessages?.isEmpty()
        if (listOfMessagesIsEmpty == true) {
            deleteChat(chat)
            return true
        }
        return true
    }

    fun deleteChat(chat: Chat): Boolean {
        val chatIdCurrent = chat.id
        val chat = allChats.values.find { it.id == chatIdCurrent }
        chat?.isDeleted = true
        deletedChats++
        return (allChats.values.remove(chat))
    }

    fun readAllMessagesInChat(chatIdForRead: Int): Int? {
        val messagesFromChat = allChats.getValue(chatIdForRead).messages
        val unreadMessages = messagesFromChat.filter { !it.isRead }
        for(message in unreadMessages){
            message.apply { isRead = true }
        }
        val countOfUnreadMessages = allChats.values.find { it.id == chatIdForRead }?.messages?.count { !it.isRead }
        readChat(chatIdForRead)
        return countOfUnreadMessages
    }

    fun readChat(chatIdForRead: Int): Boolean? {
        val chat = allChats[chatIdForRead]
        chat?.apply { isRead = true }
        return chat?.isRead
    }

    fun getUnreadChatCount(): Int{
        val count = allChats.values.count { it.isRead == false }
        return count
    }

    fun getChats(): String {
        val listOfChats = allChats.values
        try {
            for (chat in listOfChats) {
                return(chat.messages.last().text)
            }
        }
        catch ( e: Exception) {
            return("Нет сообщений")
        }
        return "Ошибка 101: Объект Message пуст"
    }

    fun readSomeMessagesInChat(chatIdCurrent: Int, messageIdLast: Int, countOfMessage: Int): Boolean {
        val chat = allChats[chatIdCurrent]
        val messages = allChats.getValue(chatIdCurrent).messages
        val lastIndex = messages.lastIndex
        val indexFromRead = messages.indexOfFirst { it.id == messageIdLast }
        val indexToRead = (indexFromRead + countOfMessage) + 1
        if (lastIndex <= indexToRead) {
            val messagesToRead = messages.subList(indexFromRead, lastIndex)
            readAllMessagesInChat(chatIdCurrent)
            return messagesToRead.last().isRead
        }
        val messagesToRead = messages.subList(indexFromRead, indexToRead)
        for (message in messagesToRead) {
            message.apply { isRead = true }
        }
        return messagesToRead.last().isRead
    }



    fun getCountDeletedMessages(): Int {
        return deletedMessages
    }

    fun getCountDeletedChats(): Int {
        return deletedChats
    }

    fun getChatId(): Int {
        return chatId
    }

    fun getMessageId(): Int {
        return messageId
    }
}