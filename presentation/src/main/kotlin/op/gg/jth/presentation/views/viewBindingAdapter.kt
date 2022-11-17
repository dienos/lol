package op.gg.jth.presentation.views

import android.graphics.Rect
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.bumptech.glide.Glide
import op.gg.jth.domain.model.remote.GamesRepo
import op.gg.jth.domain.model.remote.LeagueRepo
import op.gg.jth.presentation.R
import java.text.DecimalFormat

@BindingAdapter(value = ["game_image"])
fun setImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context).load(it).into(view)
    }
}

@BindingAdapter(value = ["leagues"])
fun setLeagues(view: RecyclerView, items: List<LeagueRepo>?) {
    items?.let {
        view.adapter?.apply {
            if (this is LeagueListAdapter) {
                submitList(items)
            }
        } ?: run {
            val adapter = LeagueListAdapter()
            view.adapter = adapter
            adapter.submitList(items)
            view.addItemDecoration(RecyclerDecoration(16))
        }
    }
}

@BindingAdapter(value = ["lp"])
fun setLp(view: TextView, lp: String) {
    val result = if (lp.contains(".") || lp.length < 4) {
        lp
    } else {
        DecimalFormat("###,###").format(lp.toLong())
    }

    view.text = view.context.getString(R.string.tier_lp, result)
}

@BindingAdapter(value = ["wins", "losses"])
fun setScore(view: TextView, wins: String, losses: String) {
    val result = if (wins.isNotEmpty() && losses.isNotEmpty()) {
        val winsValue = wins.toFloat()
        val lossesValue = losses.toFloat()

        val sum = winsValue.plus(lossesValue)

        if (sum != 0.0f) {
            view.context.getString(
                R.string.score,
                wins,
                losses,
                String.format("%.0f", winsValue.div(sum).times(100))
            )
        } else {
            view.context.getString(R.string.score_empty)
        }
    } else {
        view.context.getString(R.string.score_empty)
    }

    view.text = result
}

@BindingAdapter(value = ["games"])
fun setLastTwentyGamesScore(view: TextView, games: List<GamesRepo>?) {
    games?.let {
        var winsCount = 0
        var lossesCount = 0

        getRecentTwentyList(games).forEach {
            if (it.isWin) {
                winsCount++
            } else {
                lossesCount++
            }
        }

        view.text = view.context.getString(R.string.recent_score, winsCount, lossesCount)
    }
}

@BindingAdapter(value = ["winning_rate"])
fun setLastTwentyGameWinningRate(view: TextView, games: List<GamesRepo>?) {
    games?.let {
        var winTotalCount = 0.0f
        var loseTotalCount = 0.0f

        getRecentTwentyList(games).forEach {
            if(it.isWin) {
                winTotalCount++
            } else {
                loseTotalCount++
            }
        }

        val totalCount = winTotalCount.plus(loseTotalCount)

        view.text = "(".plus(String.format("%.0f", winTotalCount.div(totalCount).times(100))).plus("%").plus(")")
    }
}

@BindingAdapter(value = ["games_kda"])
fun setKda(view: TextView, games: List<GamesRepo>?) {
    games?.let {
        var killTotalCount = 0.0f
        var assistTotalCount = 0.0f
        var deathTotalCount = 0.0f

        getRecentTwentyList(games).forEach {
            killTotalCount += it.stats.general.kill.toFloat()
            assistTotalCount += it.stats.general.assist.toFloat()
            deathTotalCount += it.stats.general.death.toFloat()
        }

        view.text = (String.format("%.1f", killTotalCount.plus(assistTotalCount).div(deathTotalCount))).plus(":1")
    }
}

@BindingAdapter(value = ["type", "games_average"])
fun setLastTwentyGamesAverage(
    view: TextView,
    type: String,
    games: List<GamesRepo>?
) {
    games?.let {
        var totalCount = 0

        getRecentTwentyList(games).forEach {
            when (type) {
                "kill" -> {
                    totalCount += it.stats.general.kill
                }

                "assist" -> {
                    totalCount += it.stats.general.assist
                }

                "death" -> {
                    totalCount += it.stats.general.death
                }
            }
        }

        view.text = String.format("%.1f", totalCount.div(20.0f))
    }
}

private fun getRecentTwentyList(games: List<GamesRepo>): List<GamesRepo> =
    games.filterIndexed { index, _ ->
        index < 20
    }

private class RecyclerDecoration(private val divWidth: Int) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        parent.adapter?.let {
            if (parent.getChildAdapterPosition(view) != it.itemCount - 1) {
                outRect.right = divWidth
            }
        }
    }
}



