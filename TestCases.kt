class UserAuthenticator {
    fun authenticateUser(username: String, age: Int, password: String): Int {
        if (username.length > 20) {
            return -1 // Неверное имя пользователя
        }
        if (age < 6 || age > 120) {
            return -2 // Неверный возраст
        }
        if (password.length < 8 || password.length > 32) {
            return -3 // Неверная длина пароля
        }
        // Симуляция логики аутентификации (возвращается 1 для успешной аутентификации)
        return 1
    }
}

fun main() {
    val userAuthenticator = UserAuthenticator()

    val result1 = userAuthenticator.authenticateUser("xeops", 19, "12345678")
    println("Результат теста 1: $result1")

    val result2 = userAuthenticator.authenticateUser("xeopsssssssssssssssssssssantaaa", 19, "12345678")
    println("Результат теста 2: $result2")

    val result3 = userAuthenticator.authenticateUser("xeops", 5, "12345678")
    println("Результат теста 3: $result3")

    val result4 = userAuthenticator.authenticateUser("xeops", 19, "12345678123456781234567812345678")
    println("Результат теста 4: $result4")
}
