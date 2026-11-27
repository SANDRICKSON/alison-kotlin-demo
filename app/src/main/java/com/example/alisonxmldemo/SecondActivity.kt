package com.example.alisonxmldemo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        result = findViewById(R.id.resultTextView)

        var userName: String = intent.getStringExtra("username").toString()
        var userAge: String = intent.getIntExtra("userage",0).toString()

        result.text = "Your name is: $userName and your age is: $userAge"
    }
}