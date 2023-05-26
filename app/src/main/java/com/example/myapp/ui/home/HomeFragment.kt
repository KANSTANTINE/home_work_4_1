package com.example.myapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapp.R
import com.example.myapp.databinding.FragmentHomeBinding
import com.example.myapp.model.Task
import com.example.myapp.ui.home.adapter_rv.TaskAdapter
import com.example.myapp.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: TaskAdapter

    private val arrayList = ArrayList<Task>()

    override fun onCreate (savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
        adapter = TaskAdapter(arrayList)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(TaskFragment.RESULT_REQUEST){key,bundle ->
            val data: Task = bundle.getSerializable(TaskFragment.RESULT_KAY) as Task
            binding.recyclerView.adapter=adapter
            adapter.addData(data)
        }
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}