package com.nuop.tscp

data class Literature(val literatureId: Int, val type: String)

object LiteratureTest {

    fun isLiteratureIdCorrect(literatureId: Int): Boolean {
        return literatureId > 0 && literatureId < 1000000000
    }

    fun isLiteratureTypeCorrect(literatureType: String): Boolean {
        return literatureType.equals("free", ignoreCase = true)
                || literatureType.equals("trial", ignoreCase = true)
                || literatureType.equals("paid", ignoreCase = true)
    }

    private fun testLiterature(literature: Literature): Int {
        if (!isLiteratureIdCorrect(literature.literatureId)) {
            return -1
        }

        if (!isLiteratureTypeCorrect(literature.type)) {
            return -2
        }

        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val goodLiterature = Literature(1, "trial")
        val actualResultFirst = testLiterature(goodLiterature)
        println("TC1: object $goodLiterature should pass check. Expected result = 0, actual result = $actualResultFirst || ${
        if (0 == actualResultFirst) "PASSED" else "FAILED"
        }")

        val badLiteratureOne = Literature(-20, "free")
        val actualResultSecond = testLiterature(badLiteratureOne)
        println("TC2: object $badLiteratureOne should not pass check. Expected result = -1, actual result = $actualResultSecond || ${
        if (-1 == actualResultSecond) "PASSED" else "FAILED"
        }")

        val badLiteratureTwo = Literature(10, "sold")
        val actualResultThird = testLiterature(badLiteratureTwo)
        println("TC3: object $badLiteratureTwo should not pass check. Expected result = -2, actual result = $actualResultThird || ${
        if (-2 == actualResultThird) "PASSED" else "FAILED"
        }")

        if (0 != actualResultFirst || -1 != actualResultSecond || -2 != actualResultThird) {
            System.exit(-1)
        }
    }
}
