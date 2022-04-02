package kg.geektech.kotlin3.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.kotlin3.Image
import kg.geektech.kotlin3.R
import kg.geektech.kotlin3.databinding.ItemRecyclerBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val images = mutableListOf<Image>()


        fun asseptImages(image: Intent?){
            images.add(image)
        }

    inner class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        private val binding= ItemRecyclerBinding.bind(item)


        fun bind(image: Image) {
            binding.ivImage.setImageResource(image.id)
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

private fun <E> MutableList<E>.add(element: Intent?) {

}
