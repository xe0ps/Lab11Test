class TestCases {

    @Test
    fun testValidRegistration() {
        val result = authenticateUser("xeops", 19, "12345678")
        assertEquals(1, result)
    }

    @Test
    fun testInvalidLogin() {
        val result = authenticateUser("xeopsssssssssssssssssssssantaaa", 19, "12345678")
        assertEquals(-1, result)
    }

    @Test
    fun testInvalidAge() {
        val result = authenticateUser("xeops", 5, "12345678")
        assertEquals(-2, result)
    }

    @Test
    fun testInvalidPassword() {
        val result = authenticateUser("xeops", 19, "12345678123456781234567812345678")
        assertEquals(-3, result)
    }
}
