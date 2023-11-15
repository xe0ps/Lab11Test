package com.nuop.tscp

data class User(var login: String, var age: Int, var password: String)

object TestCases {

    fun authenticateUser(login: String, age: Int, password: String): Int {
        if (login.length > 30) {
            return -1 
        }

        if (age < 8) {
            return -2 
        }

        if (password.length > 30) {
            return -3 
        }

        return 1
    }

   @JvmStatic
   fun main(args: Array<String>) {
      val result1 = authenticateUser("xeops", 19, "12345678")
      println("TC1: xeops, 19, 12345678 ${
          if (result1 == 1) "Passed = 1" else "Failed"
      }")

      val result2 = authenticateUser("xeopsssssssssssssssssssssantaaa", 19, "12345678")
      println("TC2: xeopsssssssssssssssssssssantaaa, 19, 12345678 ${
          if (result2 == -1) "Passed = -1" else "Failed"
      }")

      val result3 = authenticateUser("xeops", 5, "12345678")
      println("TC3: xeops, 5, 12345678 ${
          if (result3 == -2) "Passed = -2" else "Failed"
      }")

      val result4 = authenticateUser("xeops", 19, "12345678123456781234567812345678")
      println("TC4: xeops, 19, 12345678123456781234567812345678 ${
          if (result4 == -3) "Passed = -3" else "Failed"
      }")

      if (1 != result1 || -1 != result2 || -2 != result3 || -3 != result4) {
            System.exit(-1)
      }
   }
}
