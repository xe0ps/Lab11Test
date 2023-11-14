@RunWith(AndroidJUnit4::class)
class TestCases {

    @Test
    fun testValidRegistration() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { mainActivity ->
            val result = mainActivity.authenticateUser("xeops", 19, "12345678")
            assertEquals(1, result)
        }
    }

    @Test
    fun testInvalidLogin() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { mainActivity ->
            val result = mainActivity.authenticateUser("xeopsssssssssssssssssssssantaaa", 19, "12345678")
            assertEquals(-1, result)
        }
    }

    @Test
    fun testInvalidAge() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { mainActivity ->
            val result = mainActivity.authenticateUser("xeops", 5, "12345678")
            assertEquals(-2, result)
        }
    }

    @Test
    fun testInvalidPassword() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { mainActivity ->
            val result = mainActivity.authenticateUser("xeops", 19, "12345678123456781234567812345678")
            assertEquals(-3, result)
        }
    }
}
