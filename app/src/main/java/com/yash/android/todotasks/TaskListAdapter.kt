package com.yash.android.todotasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.yash.android.todotasks.databinding.ListItemTaskBinding

class TaskListAdapter(private val myTasks: List<MyTask>) : Adapter<TaskHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemTaskBinding.inflate(inflater, parent, false)
        return TaskHolder(binding)
    }

    override fun getItemCount(): Int = myTasks.size

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        val myTask = myTasks[position]
        holder.bind(myTask)
    }
}

class TaskHolder(private val binding: ListItemTaskBinding) : ViewHolder(binding.root) {
    fun bind(myTask: MyTask) {
        binding.apply {
            listItemTitle.text = myTask.title
            listItemDescription.text = myTask.description
            listItemStatus.text = myTask.status.name
        }
    }
}