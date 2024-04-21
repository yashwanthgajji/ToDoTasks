package com.yash.android.todotasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yash.android.todotasks.databinding.FragmentTaskListBinding

class TaskListFragment : Fragment() {

    private val taskListViewModel: TaskListViewModel by viewModels()
    private var _binding: FragmentTaskListBinding ?= null
    private val binding
        get() = checkNotNull(_binding) {
            "Binding is not there... Is view available?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.taskRecyclerView.layoutManager = LinearLayoutManager(context)
        val myTasks = taskListViewModel.myTasks
        val adapter = TaskListAdapter(myTasks)
        binding.taskRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}