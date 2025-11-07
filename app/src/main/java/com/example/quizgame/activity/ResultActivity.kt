package com.example.quizgame.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizgame.databinding.ActivityResultBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ResultActivity : AppCompatActivity() {
    lateinit var resultBinding: ActivityResultBinding
    val database = FirebaseDatabase.getInstance()
    val databaseRef = database.reference.child("scores")
    val auth = FirebaseAuth.getInstance()
    private var userCorrect: String = ""
    private var userWrong: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        resultBinding = ActivityResultBinding.inflate(layoutInflater)
        val view = resultBinding.root
        setContentView(view)

        resultBinding.buttonPlayAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        resultBinding.buttonExit.setOnClickListener {
            finish()
        }

        // 🧮 Retrieve scores from Firebase Database
        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val user = auth.currentUser
                user?.let {
                    val userUid = it.uid

                    // Retrieve "correct" value
                    userCorrect = snapshot.child(userUid)
                        .child("correct")
                        .toString()


                    // Retrieve "wrong" value
                    userWrong = snapshot.child(userUid)
                        .child("wrong")
                        .toString() 

                    // Show results on TextViews
                    resultBinding.correct.text = userCorrect
                    resultBinding.wrong.text = userWrong
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // handle error (optional)
            }
        })
    }
}