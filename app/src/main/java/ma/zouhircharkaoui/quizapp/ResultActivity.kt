package ma.zouhircharkaoui.quizapp



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var textResult: TextView
    private lateinit var textViewCongratulations: TextView
    private lateinit var textViewName: TextView
    private lateinit var textViewScore: TextView
    private lateinit var restartButton: Button
    private lateinit var shareButton: Button
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textResult = findViewById(R.id.text_result)
        textViewCongratulations = findViewById(R.id.textview_congratulations)
        textViewName = findViewById(R.id.textview_name)
        textViewScore = findViewById(R.id.textview_score)
        restartButton = findViewById(R.id.restart_button)
        shareButton = findViewById(R.id.share_button)
        finishButton = findViewById(R.id.finish_button)

        val userName = intent.getStringExtra("USER_NAME") ?: "User"
        val userScore = intent.getIntExtra("USER_SCORE", 0)

        textViewName.text = userName
        textViewScore.text = "Votre score est $userScore sur 10"

        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        shareButton.setOnClickListener {
            val shareText = "J'ai terminé le quiz! Mon score est $userScore sur 10."
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareText)
            startActivity(Intent.createChooser(shareIntent, "Partager votre score"))
        }

        finishButton.setOnClickListener {
            finish()
        }
    }
}
