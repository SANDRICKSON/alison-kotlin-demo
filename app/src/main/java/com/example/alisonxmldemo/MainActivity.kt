package com.example.alisonxmldemo

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.alisonxmldemo.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val todoList = ArrayList<String>()
    private lateinit var adapter: TodoAdapter
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("TodoData", MODE_PRIVATE)

        adapter = TodoAdapter(
            todoList = todoList,
            onEditClick = { position -> showEditDialog(position) },
            onDeleteClick = { position -> showDeleteDialog(position) }
        )
        binding.recyclerView.adapter = adapter

        // 1. READ / LOAD
        retrieveData()

        // 2. CREATE / ADD
        binding.button.setOnClickListener {
            val taskText = binding.editTextText.text.toString().trim()
            if (taskText.isNotEmpty()) {
                todoList.add(taskText)
                adapter.notifyItemInserted(todoList.size - 1)
                binding.editTextText.text?.clear()
                saveData()
            }
        }
    }

    // EDIT DIALOG
    private fun showEditDialog(position: Int) {
        val editText = EditText(this).apply {
            setText(todoList[position])
            setSelection(text.length)
        }

        AlertDialog.Builder(this)
            .setTitle(R.string.edit_todo)
            .setView(editText)
            .setPositiveButton(R.string.update) { dialog, _ ->
                val newText = editText.text.toString().trim()
                if (newText.isNotEmpty()) {
                    todoList[position] = newText
                    adapter.notifyItemChanged(position)
                    saveData()
                }
                dialog.dismiss()
            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    // DELETE DIALOG
    private fun showDeleteDialog(position: Int) {
        AlertDialog.Builder(this)
            .setTitle(R.string.delete_todo)
            .setMessage(R.string.delete_confirm)
            .setPositiveButton(R.string.yes) { dialog, _ ->
                todoList.removeAt(position)
                adapter.notifyItemRemoved(position)
                adapter.notifyItemRangeChanged(position, todoList.size - position)
                saveData()
                dialog.dismiss()
            }
            .setNegativeButton(R.string.no) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    // SAVE DATA
    fun saveData() {
        val jsonArray = JSONArray()
        for (item in todoList) {
            jsonArray.put(item)
        }
        sharedPreferences.edit()
            .putString("todo_items", jsonArray.toString())
            .apply()
    }

    // RETRIEVE DATA
    fun retrieveData() {
        todoList.clear()
        val jsonString = sharedPreferences.getString("todo_items", null)
        if (!jsonString.isNullOrEmpty()) {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                todoList.add(jsonArray.getString(i))
            }
        }
        adapter.notifyDataSetChanged()
    }
}