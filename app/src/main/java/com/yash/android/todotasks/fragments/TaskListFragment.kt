package com.yash.android.todotasks.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.yash.android.todotasks.TaskListAdapter
import com.yash.android.todotasks.TaskListViewModel
import com.yash.android.todotasks.databinding.FragmentTaskListBinding
import kotlinx.coroutines.launch

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
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                taskListViewModel.myTasks.collect { myTasks ->
                    binding.taskRecyclerView.adapter = TaskListAdapter(myTasks)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}