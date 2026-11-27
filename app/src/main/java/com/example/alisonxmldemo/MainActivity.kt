package com.example.alisonxmldemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.alisonxmldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var name: EditText
    lateinit var age: EditText
    lateinit var message: EditText
    lateinit var remember: CheckBox
    lateinit var send: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        name = findViewById(R.id.editTextName)
        age = findViewById(R.id.editTextAge)
        send = findViewById(R.id.sendButton)
        message = findViewById(R.id.editTextMessage)
        remember = findViewById(R.id.checkBox3)

        send.setOnClickListener {
            saveData()
        }
    }

    override fun onResume() {
        super.onResume()
        retrieveData()
    }

    fun saveData() {
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        val userName = name.text.toString()
        val userAge = age.text.toString()
        val userMessage = message.text.toString()
        val isChecked = remember.isChecked

        val editor = sharedPreferences.edit()
        editor.putString("key name", userName)
        editor.putString("key message", userMessage)
        editor.putString("key age", userAge)
        editor.putBoolean("key remember", isChecked)
        editor.apply()
    }

    fun retrieveData() {
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("key name", "")
        val userAge = sharedPreferences.getString("key age", "")
        val userMessage = sharedPreferences.getString("key message", "")
        val isChecked = sharedPreferences.getBoolean("key remember", false)

        name.setText(userName)
        age.setText(userAge)
        message.setText(userMessage)
        remember.isChecked = isChecked
    }
}