package kg.geektech.kotlin3.main

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlin3.R
import kg.geektech.kotlin3.databinding.ItemRecyclerBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var images = mutableListOf<Uri>()

        @SuppressLint("NotifyDataSetChanged")
        fun acceptImages(image: MutableList<Uri>){
            images = image
            notifyDataSetChanged()
        }

    inner class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        private val binding= ItemRecyclerBinding.bind(item)


        fun bind(image: Uri) {
            binding.ivImage.setImageURI(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}

