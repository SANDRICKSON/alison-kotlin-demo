package com.example.alisonxmldemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alisonxmldemo.databinding.ItemTodoBinding

class TodoAdapter(
    private val todoList: MutableList<String>,
    private val onEditClick: (Int) -> Unit,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentPos = holder.bindingAdapterPosition
        if (currentPos == RecyclerView.NO_POSITION) return
        val item = todoList[currentPos]
        holder.binding.textViewTask.text = item

        holder.binding.buttonEdit.setOnClickListener {
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onEditClick(pos)
            }
        }

        holder.binding.buttonDelete.setOnClickListener {
            val pos = holder.bindingAdapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onDeleteClick(pos)
            }
        }
    }

    override fun getItemCount(): Int = todoList.size
}