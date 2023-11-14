package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    private lateinit var answerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        answerText = findViewById(R.id.answerText)
        answerText.text = "Цена = " + intent.getDoubleExtra("answer", 0.0).toString()
    }
}