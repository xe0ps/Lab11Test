class TestCases {

    @Test
    fun testValidRegistration() {
        val result = authenticateUser("xeops", 19, "12345678")
        if (result == 1) {
            println("TC1: Passed = 1")
        } else {
            println("TC1: Failed")
        }
        assertEquals(1, result)
    }

    @Test
    fun testInvalidLogin() {
        val result = authenticateUser("xeopsssssssssssssssssssssantaaa", 19, "12345678")
        if (result == -1) {
            println("TC2: Passed = -1")
        } else {
            println("TC2: Failed")
        }
        assertEquals(-1, result)
    }

    @Test
    fun testInvalidAge() {
        val result = authenticateUser("xeops", 5, "12345678")
        if (result == -2) {
            println("TC3: Passed = -2")
        } else {
            println("TC3: Failed")
        }
        assertEquals(-2, result)
    }

    @Test
    fun testInvalidPassword() {
        val result = authenticateUser("xeops", 19, "12345678123456781234567812345678")
        if (result == -3) {
            println("TC4: Passed = -3")
        } else {
            println("TC4: Failed")
        }
        assertEquals(-3, result)
    }
}
