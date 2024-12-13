package ma.zouhircharkaoui.quizapp



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionsActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var optionOneTextView: TextView
    private lateinit var checkButton: Button

    private var score = 0
    private var currentQuestionIndex = 0

    private val questions = listOf(
        Question("What is the capital of France?", "Paris", listOf("Berlin", "Madrid", "Paris", "Rome")),
        Question("Which animal is known as the king of the jungle?", "Lion", listOf("Lion", "Elephant", "Tiger", "Giraffe"))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        questionTextView = findViewById(R.id.question_text_view)
        optionOneTextView = findViewById(R.id.text_view_option_one)
        checkButton = findViewById(R.id.button_check)

        loadQuestion()

        checkButton.setOnClickListener {
            if (optionOneTextView.text == questions[currentQuestionIndex].correctAnswer) {
                score++
            }

            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion()
            } else {
                // Passer au résultat
                val username = intent.getStringExtra("USER_NAME") ?: "User"
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("USER_NAME", username)
                intent.putExtra("USER_SCORE", score)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        val question = questions[currentQuestionIndex]
        questionTextView.text = question.question
        optionOneTextView.text = question.options[0]
    }
}

data class Question(val question: String, val correctAnswer: String, val options: List<String>)
