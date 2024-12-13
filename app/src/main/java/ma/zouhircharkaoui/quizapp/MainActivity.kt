package ma.zouhircharkaoui.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.name)
        startButton = findViewById(R.id.button_start)

        startButton.setOnClickListener {
            val name = nameEditText.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Veuillez entrer un nom", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
