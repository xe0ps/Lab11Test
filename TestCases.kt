class TestCases {

    private val userAuthenticator = UserAuthenticator()

    @Test
    fun testValidRegistration() {
        val result = userAuthenticator.authenticateUser("xeops", 19, "12345678")
        assertEquals(1, result)
    }

    @Test
    fun testInvalidLogin() {
        val result = userAuthenticator.authenticateUser("xeopsssssssssssssssssssssantaaa", 19, "12345678")
        assertEquals(-1, result)
    }

    @Test
    fun testInvalidAge() {
        val result = userAuthenticator.authenticateUser("xeops", 5, "12345678")
        assertEquals(-2, result)
    }

    @Test
    fun testInvalidPassword() {
        val result = userAuthenticator.authenticateUser("xeops", 19, "12345678123456781234567812345678")
        assertEquals(-3, result)
    }
}
