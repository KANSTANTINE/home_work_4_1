package com.example.myapp.ui.onBord.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapp.databinding.ItemOnbordingBinding
import com.example.myapp.databinding.ItemTaskBinding
import com.example.myapp.model.OnBoard
import com.example.myapp.util.loadImage

class OnBoardingAdapter(private val onClick:() ->Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf(
        OnBoard("https://upload.wikimedia.org/wikipedia/ru/thumb/8/8c/Umurzakova.jpg/230px-Umurzakova.jpg" , "Task manager 1", " desk"),
        OnBoard("https://www.stackfield.com/images/blog/Cover_2020-06-02_01_v2.png","Task manager 2 " , " desk"),
        OnBoard("https://toggl.com/blog/wp-content/uploads/2018/09/project-task-list.jpg","Task manager 3 " , " desk")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
       return OnBoardingViewHolder(ItemOnbordingBinding.inflate
           (LayoutInflater.from(parent.context),parent,
           false))
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingViewHolder( private val binding:ItemOnbordingBinding):
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.bordTitle.text = onBoard.title
            binding.bordDeck.text = onBoard.deck
            binding.bordImage.loadImage(onBoard.image)
            binding.skip.isVisible = adapterPosition!=2
            binding.butBoard.isVisible = adapterPosition ==2
            binding.skip.setOnClickListener {
                onClick()
            }
            binding.butBoard.setOnClickListener {
                onClick()
            }

        }
    }
}