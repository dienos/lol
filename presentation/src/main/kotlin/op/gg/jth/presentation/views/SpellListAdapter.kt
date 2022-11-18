package op.gg.jth.presentation.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import op.gg.jth.domain.model.remote.SpellsRepo
import op.gg.jth.presentation.BR
import op.gg.jth.presentation.databinding.SpellItemBinding

class SpellListAdapter(var spells: List<SpellsRepo>) :
    RecyclerView.Adapter<SpellListAdapter.SpellViewHolder>() {

    private lateinit var binding: SpellItemBinding

    inner class SpellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: SpellsRepo) {
            binding.setVariable(BR.spellItem, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        binding =
            SpellItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpellViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        holder.bind(spells[position])
    }

    override fun getItemCount(): Int = spells.size
}
