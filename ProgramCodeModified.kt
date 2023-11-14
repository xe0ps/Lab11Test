// Приклад взаємодії користувача з БД  
// Клас, який представляє об'єкт користувача
data class User(   
    var login: String = "",
    var email: String = "",
    var password: String = "",
    var age: Int = 0
)

// Клас, який взаємодіє з базою даних Firebase для збереження та видалення користувачів
class UserRepository {
    private val database = FirebaseDatabase.getInstance().reference
    private val userDBRef = database.child("users")

    // Збереження або оновлення користувача в Firebase
    fun createOrUpdateUser(user: User) {
        val userNodeRef = userDBRef.child(user.login)
        userNodeRef.setValue(user)
    }

    // Видалення користувача з Firebase
    fun deleteUser(user: User) {
        val userNodeRef = userDBRef.child(user.login)
        userNodeRef.removeValue()
    }
}

// Клас для описування логіки взаємодії користувача з додатком, включаючи реєстрацію користувачів, перевірку їх даних і збереження їх у базі даних Firebase.
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding   

    private val userRepository = UserRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val regButton = findViewById<Button>(R.id.regButton)
        regButton.setOnClickListener {
            // Отримання введених даних користувача
            val login = findViewById<EditText>(R.id.loginText).text.toString()
            val email = findViewById<EditText>(R.id.emailText).text.toString()
            val password = findViewById<EditText>(R.id.passwordText).text.toString()
            val age = findViewById<EditText>(R.id.ageNumber).text.toString().toInt()

            // Перевірка валідності введених даних користувача
            val result = authenticateUser(login, age, password)

            // Створення об'єкта користувача
            val user = User(login, email, password, age)

            // Обробка результату автентифікації
            when (result) {
                1 -> {
                    val message = "Користувач $login зареєстрований"
                    displayMessage(message)

                    // Використання UserRepository для створення або оновлення користувача в Firebase
                    userRepository.createOrUpdateUser(user)
                }
                -1 -> {
                    val message = "Логін не відповідає умовам (довжина більше 30)"
                    displayMessage(message)
                }   
                -2 -> {
                    val message = "Вік не відповідає умовам (треба більше 8)"
                    displayMessage(message)
                }
                -3 -> {
                    val message = "Пароль не відповідає умовам (довжина більше 30)"
                    displayMessage(message)
                }
            }
        }
    }

    // Виведення повідомлення користувачу  
    fun displayMessage(message: String) {
        // Тут виводиться повідомлення користувачу, наприклад, за допомогою Toast.  
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Перевірка валідності даних користувача
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
