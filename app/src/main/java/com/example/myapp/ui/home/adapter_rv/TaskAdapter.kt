package com.example.myapp.ui.home.adapter_rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.databinding.ItemTaskBinding
import com.example.myapp.model.Task



    class TaskAdapter(private val data: ArrayList<Task>) :
        RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

        fun addData(task:Task){
            data.add(0,task)
            notifyItemChanged(0)

        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
            return TaskViewHolder(
                ItemTaskBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
            holder.bind(data.get(position))
        }

        override fun getItemCount(): Int {
            return data.size
        }

        inner class TaskViewHolder(private val binding: ItemTaskBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(task: Task) {
                binding.tvTitle.text = task.title
                binding.tvDesk.text = task.deck
            }


        }
    }
