package op.gg.jth.presentation.views

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import op.gg.jth.domain.model.remote.GamesRepo
import op.gg.jth.presentation.BR
import op.gg.jth.presentation.databinding.GameItemBinding

class GameListAdapter : ListAdapter<GamesRepo, GameListAdapter.GameViewHolder>(GameDiffCallback) {
    private lateinit var binding: GameItemBinding
    var currentGames : ArrayList<GamesRepo> = arrayListOf()

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: GamesRepo) {
            binding.setVariable(BR.gameItem, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        binding = GameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onViewRecycled(holder: GameViewHolder) {
        super.onViewRecycled(holder)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}

object GameDiffCallback : DiffUtil.ItemCallback<GamesRepo>() {
    override fun areItemsTheSame(oldItem: GamesRepo, newItem: GamesRepo): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: GamesRepo, newItem: GamesRepo): Boolean {
        return oldItem.createDate == newItem.createDate

    }
}