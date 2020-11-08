package lesson1_9

import org.junit.Test

import org.junit.Assert.*

internal class UserServiceTest{

    @Test
    fun addUser_successAdd() {

        val userService = UserService()

        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )

        val result = userService.addUser(user)

        assertTrue(result)
    }

    @Test
    fun deleteUser_successDelete() {

        val userService = UserService()

        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )

        userService.addUser(user)
        val result = userService.deleteUser(user)

        assertTrue(result)
    }

    @Test
    fun createPairOfUser_successAdd() {

        val userService = UserService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        userService.createPairOfUser(user, user2)


        val result = userService.pairsOfUsers.isNotEmpty()

        assertTrue(result)
    }

    @Test
    fun checkPairOfUserInPairsOfUsers_successCheck() {

        val userService = UserService()
        val user = User(
            1,
            "Ivan",
            "Ivanov"
        )
        val user2 = user.copy(id = 2)
        val user3 = user.copy(id = 2)
        val user4 = user.copy(id = 1)
        userService.createPairOfUser(user, user2)


        val result = userService.checkPairOfUserInPairsOfUsers(user3, user4)

        assertTrue(result)
    }
}