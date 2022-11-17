package op.gg.jth.presentation.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import op.gg.jth.domain.model.remote.LeagueRepo
import op.gg.jth.presentation.BR
import op.gg.jth.presentation.databinding.LeagueItemBinding

class LeagueListAdapter : ListAdapter<LeagueRepo, LeagueListAdapter.LeagueViewHolder>(FlowerDiffCallback) {

    private lateinit var binding: LeagueItemBinding

    inner class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: LeagueRepo) {
            binding.setVariable(BR.leagueItem, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        binding = LeagueItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LeagueViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object FlowerDiffCallback : DiffUtil.ItemCallback<LeagueRepo>() {
    override fun areItemsTheSame(oldItem: LeagueRepo, newItem: LeagueRepo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LeagueRepo, newItem: LeagueRepo): Boolean {
        return true
    }
}