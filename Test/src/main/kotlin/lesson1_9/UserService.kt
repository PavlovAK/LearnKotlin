package lesson1_9

class UserService() {

    val pairsOfUsers = mutableListOf<PairOfUser>()
    val users = mutableSetOf<User>()

    fun addUser(user: User): Boolean {
        return (users.add(user))
    }

    fun createPairOfUser(user1: User, user2: User): PairOfUser {
        val checkTakes = checkPairOfUserInPairsOfUsers(user1, user2)
        if(checkTakes == false) {
            val pairOfUser = PairOfUser(user1, user2)
            pairsOfUsers.add(pairOfUser)
            return pairOfUser
        }
        return pairsOfUsers.last()
    }

    fun checkPairOfUserInPairsOfUsers(user1: User, user2: User): Boolean {
        val userId1 = user1.id
        val userId2 = user2.id
        for (pairOfUser in pairsOfUsers) {
            if (pairOfUser.user1.id == userId1 && pairOfUser.user2.id == userId2) return true
            if (pairOfUser.user1.id == userId2 && pairOfUser.user2.id == userId1) return true
        }
        return false
    }

    fun deleteUser(user: User): Boolean {
        return (users.remove(user))
    }
}