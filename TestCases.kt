class TestCases {
    suspend fun authenticateUser(login: String, age: Int, password: String): Int {
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

suspend fun test() {
    console.log("TC1: ")
    if (sendMessage(mapOf("login" to "xeops", "age" to "19", "password" to "12345678")) == 1) {
        console.log("TC1: Passed = 1")
    } else {
        console.log("Failed")
    }

    console.log("TC2: ")
    if (sendMessage(mapOf("login" to "xeopsssssssssssssssssssssantaaa", "age" to "19", "password" to "12345678")) == -1) {
        console.log("TC2: Passed = -1")
    } else {
        console.log("Failed")
    }

    console.log("TC3: ")
    if (sendMessage(mapOf("login" to "xeops", "age" to "5", "password" to "12345678")) == -2) {
        console.log("TC3: Passed = -2")
    } else {
        console.log("Failed")
    }

    console.log("TC4: ")
    if (sendMessage(mapOf("login" to "xeops", "age" to "19", "password" to "12345678123456781234567812345678")) == -3) {
        console.log("TC4: Passed = -3")
    } else {
        console.log("Failed")
    }
}

suspend fun sendMessage(data: Map<String, String>): Int {
    val userAuthenticator = TestCases()
    return userAuthenticator.authenticateUser(
        data["login"] ?: "",
        data["age"]?.toIntOrNull() ?: 0,
        data["password"] ?: ""
    )
}

suspend fun main() {
    test()
}
