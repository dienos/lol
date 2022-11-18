package op.gg.jth.presentation.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import op.gg.jth.data.model.local.LocalChampion
import op.gg.jth.presentation.BR
import op.gg.jth.presentation.databinding.MostWinningRateItemBinding

class MostWinningRateListAdapter(var champions: List<LocalChampion>) :
    RecyclerView.Adapter<MostWinningRateListAdapter.MostWinningRateViewHolder>() {

    private lateinit var binding: MostWinningRateItemBinding

    inner class MostWinningRateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: LocalChampion) {
            binding.setVariable(BR.championItem, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostWinningRateViewHolder {
        binding =
            MostWinningRateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MostWinningRateViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MostWinningRateViewHolder, position: Int) {
        holder.bind(champions[position])
    }

    override fun getItemCount(): Int = champions.size

}
