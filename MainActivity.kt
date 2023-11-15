class MainActivity {
    fun authenticateUser(login: String, age: Int, password: String): Int {

        if (login.length > 30) {
            return -1 // Логін не відповідає умові 1.
        }

        if (age < 8) {
            return -2 // Вік не відповідає умові 3.
        }

        if (password.length > 30) {
            return -3 // Пароль не відповідає умові 4.
        }

        // Якщо всі умови виконані, користувач успішно авторизований.
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
