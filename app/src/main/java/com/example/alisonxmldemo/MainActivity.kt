package com.example.alisonxmldemo

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.alisonxmldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var name : EditText
    lateinit var age: EditText
    lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        name = findViewById(R.id.editTextName)
        age = findViewById(R.id.editTextAge)
        send = findViewById(R.id.sendButton)

        send.setOnClickListener {
            val userName : String = name.text.toString()
            val userAge : Int = age.text.toString().toInt()
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("username",userName)
            intent.putExtra("userage",userAge)
            startActivity(intent)
        }

    }






}