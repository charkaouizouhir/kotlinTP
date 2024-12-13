import ma.zouhircharkaoui.quizapp.R
import ma.zouhircharkaoui.quizapp.model.Question


object Constants {
    fun getQuestions(): List<Question> {
        return listOf(
            Question(1, "À quel pays appartient ce drapeau ?", R.drawable.morocco, "Maroc", "Egypte", "France", "Espagne", 1),
            Question(2, "À quel pays appartient ce drapeau ?", R.drawable.argentina_flag, "Allemagne", "Argentine", "Autriche", "Australie", 2)
        )
    }
}
