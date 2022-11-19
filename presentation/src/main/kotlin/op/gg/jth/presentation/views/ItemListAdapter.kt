package op.gg.jth.presentation.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import op.gg.jth.data.model.local.ItemUrl
import op.gg.jth.presentation.BR
import op.gg.jth.presentation.databinding.ItemItemBinding

class ItemListAdapter(var items: List<ItemUrl>) :
    RecyclerView.Adapter<ItemListAdapter.ItemViewHolder>() {

    private lateinit var binding: ItemItemBinding

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ItemUrl) {
            binding.setVariable(BR.item, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}