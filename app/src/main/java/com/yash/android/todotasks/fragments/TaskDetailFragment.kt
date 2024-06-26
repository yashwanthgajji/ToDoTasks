package com.yash.android.todotasks.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yash.android.todotasks.models.MyTask
import com.yash.android.todotasks.models.TaskStatus
import com.yash.android.todotasks.databinding.FragmentTaskDetailBinding
import java.util.Date
import java.util.UUID

class TaskDetailFragment : Fragment() {

    private var _binding: FragmentTaskDetailBinding ?= null
    private val binding
        get() = checkNotNull(_binding) {
            "Binding is null... Is view visible??"
        }

    lateinit var myTask: MyTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myTask = MyTask(
            taskID = UUID.randomUUID(),
            title = "Complete the project",
            description = "Its a very big project. It takes some time. Wait for a few weeks.",
            status = TaskStatus.InProgress,
            dateCreated = Date()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            taskDetailTitleTextview.text = myTask.title
            taskDetailDescriptionTextview.text = myTask.description
            when (myTask.status) {
                TaskStatus.Todo -> {
                    taskDetailTodoRadiobutton.isChecked = true
                }
                TaskStatus.InProgress -> {
                    taskDetailInprogressRadiobutton.isChecked = true
                }
                TaskStatus.Done -> {
                    taskDetailDoneRadiobutton.isChecked = true
                }
            }
            taskDetailTodoRadiobutton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked && myTask.status != TaskStatus.Todo) {
                    myTask = myTask.copy(status = TaskStatus.Todo)
                }
            }
            taskDetailInprogressRadiobutton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked && myTask.status != TaskStatus.InProgress) {
                    myTask = myTask.copy(status = TaskStatus.InProgress)
                }
            }
            taskDetailDoneRadiobutton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked && myTask.status != TaskStatus.Done) {
                    myTask = myTask.copy(status = TaskStatus.Done)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}