package com.example.quizgame.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.quizgame.databinding.ActivityQuizBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.random.Random

class QuizActivity : AppCompatActivity() {
    lateinit var quizBinding: ActivityQuizBinding
    val database = FirebaseDatabase.getInstance()
    val databaseReference = database.reference.child("questions")
    var question = ""
    var answerA = ""
    var answerB = ""
    var answerC = ""
    var answerD = ""
    var correctAnswer = ""
    var questionCount = 0
    var questionNumber = 0
    var userAnswer = ""
    var userCorrect = 0
    var userWrong = 0
    lateinit var timer: CountDownTimer
    private val totalTime = 25000L
    var timerContinue = false
    var leftTime = totalTime
    val auth = FirebaseAuth.getInstance()
    val user = auth.currentUser
    val scoreRef = database.reference
    val questions = HashSet<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        quizBinding = ActivityQuizBinding.inflate(layoutInflater)
        val view = quizBinding.root
        setContentView(view)

        do {
            val number = Random.nextInt(1, 16)
            questions.add(number)
        } while (questions.size < 5)


        gameLogic()

        quizBinding.buttonNext.setOnClickListener {
            resetTimer()
            gameLogic()
        }

        quizBinding.buttonFinish.setOnClickListener {
            sendScore()
        }

        quizBinding.tvA.setOnClickListener {
            pauseTimer()
            userAnswer = "a"

            if (userAnswer == correctAnswer) {

                quizBinding.tvA.setBackgroundColor(Color.GREEN)
                userCorrect++
                quizBinding.tvCorrect.text = userCorrect.toString()

            } else {

                quizBinding.tvA.setBackgroundColor(Color.RED)
                userWrong++
                quizBinding.tvWrong.text = userWrong.toString()
                findAnswer()

            }
            disableClickableOfOptions()
        }

        quizBinding.tvB.setOnClickListener {
            pauseTimer()
            userAnswer = "b"
            if (userAnswer == correctAnswer) {
                quizBinding.tvB.setBackgroundColor(Color.GREEN)
                userCorrect++
                quizBinding.tvCorrect.text = userCorrect.toString()
            } else {
                quizBinding.tvB.setBackgroundColor(Color.RED)
                userWrong++
                quizBinding.tvWrong.text = userWrong.toString()
                findAnswer()
            }
            disableClickableOfOptions()
        }

        quizBinding.tvC.setOnClickListener {
            pauseTimer()
            userAnswer = "c"
            if (userAnswer == correctAnswer) {
                quizBinding.tvC.setBackgroundColor(Color.GREEN)
                userCorrect++
                quizBinding.tvCorrect.text = userCorrect.toString()
            } else {
                quizBinding.tvC.setBackgroundColor(Color.RED)
                userWrong++
                quizBinding.tvWrong.text = userWrong.toString()
                findAnswer()
            }
            disableClickableOfOptions()
        }

        quizBinding.tvD.setOnClickListener {
            pauseTimer()
            userAnswer = "d"
            if (userAnswer == correctAnswer) {
                quizBinding.tvD.setBackgroundColor(Color.GREEN)
                userCorrect++
                quizBinding.tvCorrect.text = userCorrect.toString()
            } else {
                quizBinding.tvD.setBackgroundColor(Color.RED)
                userWrong++
                quizBinding.tvWrong.text = userWrong.toString()
                findAnswer()
            }
            disableClickableOfOptions()
        }

    }

    private fun gameLogic() {
        restoreOptions()
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                questionCount = snapshot.childrenCount.toInt()

                if (questionNumber < questions.size) {
                    question = snapshot.child(questions.elementAt(questionNumber).toString()).child("q").value.toString()
                    answerA = snapshot.child(questions.elementAt(questionNumber).toString()).child("a").value.toString()
                    answerB = snapshot.child(questions.elementAt(questionNumber).toString()).child("b").value.toString()
                    answerC = snapshot.child(questions.elementAt(questionNumber).toString()).child("c").value.toString()
                    answerD = snapshot.child(questions.elementAt(questionNumber).toString()).child("d").value.toString()
                    correctAnswer = snapshot.child(questions.elementAt(questionNumber).toString()).child("answer").value.toString()

                    quizBinding.tvQuestion.text = question
                    quizBinding.tvA.text = answerA
                    quizBinding.tvB.text = answerB
                    quizBinding.tvC.text = answerC
                    quizBinding.tvD.text = answerD

                    quizBinding.progressBarQuiz.visibility = View.INVISIBLE
                    quizBinding.linearLayoutInfo.visibility = View.VISIBLE
                    quizBinding.linearLayoutQuestion.visibility = View.VISIBLE
                    quizBinding.linearLayoutButton.visibility = View.VISIBLE

                    startTimer()

                } else {
                    val dialogMessage = AlertDialog.Builder(this@QuizActivity)
                    dialogMessage.setTitle("Quiz Game")
                    dialogMessage.setMessage("Congratulations!!! \nYou have completed all the questions.Do you want to see the result?")
                    dialogMessage.setCancelable(false)
                    dialogMessage.setPositiveButton("See Result") { dialogWindow, position ->
                        sendScore()

                    }
                    dialogMessage.setNegativeButton("Play Again") { dialogWindow, position ->
                        val intent = Intent(this@QuizActivity, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    }

                    dialogMessage.create().show()

                }

                questionNumber++
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()

            }
        })
    }

    fun findAnswer() {
        when (correctAnswer) {
            "a" -> quizBinding.tvA.setBackgroundColor(Color.GREEN)
            "b" -> quizBinding.tvB.setBackgroundColor(Color.GREEN)
            "c" -> quizBinding.tvC.setBackgroundColor(Color.GREEN)
            "d" -> quizBinding.tvD.setBackgroundColor(Color.GREEN)

        }
    }

    fun disableClickableOfOptions() {
        quizBinding.tvA.isClickable = false
        quizBinding.tvB.isClickable = false
        quizBinding.tvC.isClickable = false
        quizBinding.tvD.isClickable = false
    }

    fun restoreOptions() {
        quizBinding.tvA.setBackgroundColor(Color.WHITE)
        quizBinding.tvB.setBackgroundColor(Color.WHITE)
        quizBinding.tvC.setBackgroundColor(Color.WHITE)
        quizBinding.tvD.setBackgroundColor(Color.WHITE)

        quizBinding.tvA.isClickable = true
        quizBinding.tvB.isClickable = true
        quizBinding.tvC.isClickable = true
        quizBinding.tvD.isClickable = true
    }

    private fun startTimer() {
        timer = object : CountDownTimer(leftTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                leftTime = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                disableClickableOfOptions()
                resetTimer()
                updateCountDownText()
                quizBinding.tvQuestion.text = "Sorry, Time is up! Continue with the next question"
                timerContinue = false

            }

        }.start()
        timerContinue = true
    }

    fun updateCountDownText() {
        val remainingTime: Int = (leftTime / 1000).toInt()
        quizBinding.tvTime.text = remainingTime.toString()

    }

    fun pauseTimer() {
        timer.cancel()
        timerContinue = false
    }

    fun resetTimer() {
        pauseTimer()
        leftTime = totalTime
        updateCountDownText()
    }

    fun sendScore() {
        user?.let {
            val userID = it.uid
            scoreRef.child("scores").child(userID).child("correct").setValue(userCorrect)
            scoreRef.child("scores").child(userID).child("wrong").setValue(userWrong)
                .addOnSuccessListener {

                    Toast.makeText(
                        applicationContext,
                        "Scores sent to database successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this@QuizActivity, ResultActivity::class.java)
                    startActivity(intent)
                    finish()
                }

        }

    }

}