class UserAuthenticator {
    fun authenticateUser(username: String, age: Int, password: String): Int {
        if (username.length > 20) {
            return -1 // Invalid username
        }
        if (age < 6 || age > 120) {
            return -2 // Invalid age
        }
        if (password.length < 8 || password.length > 32) {
            return -3 // Invalid password length
        }
        // Simulating authentication logic (returning 1 for valid authentication)
        return 1
    }
}
