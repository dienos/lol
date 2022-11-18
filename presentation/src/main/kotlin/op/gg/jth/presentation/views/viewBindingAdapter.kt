package op.gg.jth.presentation.views

import android.graphics.Rect
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.createBitmap
import androidx.core.view.get
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.bumptech.glide.Glide
import op.gg.jth.data.extension.getWinningRate
import op.gg.jth.data.model.local.LocalChampion
import op.gg.jth.domain.model.remote.GamesRepo
import op.gg.jth.domain.model.remote.LeagueRepo
import op.gg.jth.domain.model.remote.PositionsRepo
import op.gg.jth.domain.model.remote.SpellsRepo
import op.gg.jth.presentation.R
import op.gg.jth.presentation.viewmodels.MainViewModel
import op.gg.jth.presentation.viewmodels.MainViewModel.Companion.IMAGE_TYPE_CIRCLE
import op.gg.jth.presentation.viewmodels.MainViewModel.Companion.POSITION_ADC
import op.gg.jth.presentation.viewmodels.MainViewModel.Companion.POSITION_JNG
import op.gg.jth.presentation.viewmodels.MainViewModel.Companion.POSITION_MID
import op.gg.jth.presentation.viewmodels.MainViewModel.Companion.POSITION_SUP
import op.gg.jth.presentation.viewmodels.MainViewModel.Companion.POSITION_TOP
import java.text.DecimalFormat


@BindingAdapter(value = ["type", "game_image"])
fun setImage(view: ImageView, type: String, url: String?) {
    url?.let {
        if (type == IMAGE_TYPE_CIRCLE) {
            Glide.with(view.context).load(it).circleCrop().into(view)
        } else {
            Glide.with(view.context).load(it).into(view)
        }
    }
}

@BindingAdapter(value = ["game_position"])
fun setPositionImage(view: ImageView, positions: List<PositionsRepo>?) {
    positions?.let {
        var imageId: Int = -1

        if (positions.isNotEmpty()) {
            when (positions[0].positionName) {
                POSITION_SUP -> imageId = R.drawable.ic_icon_lol_sup
                POSITION_JNG -> imageId = R.drawable.ic_icon_lol_jng
                POSITION_ADC -> imageId = R.drawable.ic_icon_lol_bot
                POSITION_TOP -> imageId = R.drawable.ic_icon_lol_top
                POSITION_MID -> imageId = R.drawable.ic_icon_lol_mid
            }

            if (imageId != -1) {
                view.setImageResource(imageId)
            }

        }
    }
}

@BindingAdapter(value = ["spells"])
fun setSkills(view: RecyclerView, items: List<SpellsRepo>?) {
    items?.let {
        view.adapter = SpellListAdapter(it)
        view.layoutManager = GridLayoutManager(view.context, 2)
    }
}

@BindingAdapter(value = ["view_model", "games"])
fun setGames(view: RecyclerView, viewModel: MainViewModel, items: List<GamesRepo>?) {
    items?.let {
        if(viewModel.needRefresh) {
            view.adapter = null
        }

        view.adapter?.let {
            if (it is GameListAdapter) {
                it.currentGames.addAll(items)
                it.submitList(it.currentGames)
            }
        } ?: run {
            val adapter = GameListAdapter()
            val layoutManager = LinearLayoutManager(view.context)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            view.layoutManager = layoutManager
            view.itemAnimator = DefaultItemAnimator()
            view.adapter = adapter
            adapter.currentGames.addAll(items)
            adapter.submitList(items)
            viewModel.needRefresh = false

            view.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val lastVisibleItemPosition =
                        (recyclerView.layoutManager as LinearLayoutManager)
                            .findLastVisibleItemPosition()
                    val itemTotalCount = recyclerView.adapter?.itemCount?.minus(1)

                    itemTotalCount?.let {
                        itemCount ->
                        if (itemCount - 20 <= lastVisibleItemPosition) {
                            if(viewModel.progressFlow.value.not()) {
                                viewModel.getGames(adapter.currentGames[itemTotalCount].createDate)
                            }
                        }
                    }
                }
            })
        }

    }
}

@BindingAdapter(value = ["leagues"])
fun setLeagues(view: RecyclerView, items: List<LeagueRepo>?) {
    items?.let {
        val adapter = LeagueListAdapter()
        val layoutManager = LinearLayoutManager(view.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        view.layoutManager = layoutManager
        view.itemAnimator = DefaultItemAnimator()
        view.adapter = adapter
        adapter.submitList(items)
        view.addItemDecoration(RecyclerDecoration(16))
    }
}

private var isFirst = true

@BindingAdapter(value = ["most_winning_rate"])
fun setMostWinningRate(view: RecyclerView, items: List<LocalChampion>?) {
    items?.let {
        val adapter = MostWinningRateListAdapter(it)
        view.adapter = adapter
        if (isFirst) {
            view.addItemDecoration(RecyclerDecoration(36))
            isFirst = false
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
                String.format("%.0f", sum.getWinningRate(wins = winsValue))
            )
        } else {
            view.context.getString(R.string.score_empty)
        }
    } else {
        view.context.getString(R.string.score_empty)
    }

    view.text = result
}

@BindingAdapter(value = ["last_twenty_games"])
fun setLastTwentyGamesScore(view: TextView, games: List<GamesRepo>?) {
    games?.let {
        var winsCount = 0
        var lossesCount = 0

        it.forEach { game ->
            if (game.isWin) {
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

        it.forEach { game ->
            if (game.isWin) {
                winTotalCount++
            } else {
                loseTotalCount++
            }
        }

        val totalCount = winTotalCount.plus(loseTotalCount)

        view.text = view.context.getString(
            R.string.winning_rate,
            String.format("%.0f", winTotalCount.div(totalCount).times(100))
        )
    }
}

@BindingAdapter(value = ["games_kda"])
fun setKda(view: TextView, games: List<GamesRepo>?) {
    games?.let {
        var killTotalCount = 0.0f
        var assistTotalCount = 0.0f
        var deathTotalCount = 0.0f

        it.forEach { game ->
            killTotalCount += game.stats.general.kill.toFloat()
            assistTotalCount += game.stats.general.assist.toFloat()
            deathTotalCount += game.stats.general.death.toFloat()
        }

        view.text = (String.format(
            "%.1f",
            killTotalCount.plus(assistTotalCount).div(deathTotalCount)
        )).plus(":1")
    }
}

@BindingAdapter(value = ["most_champion"])
fun setGameWinningAverage(
    view: TextView,
    champion: List<LocalChampion>?,
) {
    champion?.let {
        if (it.isNotEmpty()) {
            if (it[0].winningRate == 100.0f) {
                view.setTextColor(view.context.getColor(R.color.darkish_pink))
            } else {
                view.setTextColor(view.context.getColor(R.color.dark_grey))
            }

            view.text =
                view.context.getString(R.string.rate, String.format("%.0f", it[0].winningRate))
        }
    }
}

@BindingAdapter(value = ["most_champion"])
fun setGameWinningAverage(
    view: TextView,
    champion: LocalChampion?,
) {
    champion?.let {
        if (it.winningRate == 100.0f) {
            view.setTextColor(view.context.getColor(R.color.darkish_pink))
        } else {
            view.setTextColor(view.context.getColor(R.color.dark_grey))
        }

        view.text = view.context.getString(R.string.rate, String.format("%.0f", it.winningRate))
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

        it.forEach { game ->
            when (type) {
                "kill" -> {
                    totalCount += game.stats.general.kill
                }

                "assist" -> {
                    totalCount += game.stats.general.assist
                }

                "death" -> {
                    totalCount += game.stats.general.death
                }
            }
        }

        view.text = String.format("%.1f", totalCount.div(20.0f))
    }
}

@BindingAdapter(value = ["gameLength"])
fun setGameLength(view: TextView, gameLength: Int) {
    val minute: Int = gameLength / 60
    val second: Int = gameLength % 60

    val minuteValue = if (minute == 0) {
        "00"
    } else {
        if (minute < 10) {
            "0".plus(minute.toString())
        } else {
            minute.toString()
        }
    }

    val secondValue = if (second == 0) {
        "00"
    } else {
        if (second < 10) {
            "0".plus(second.toString())
        } else {
            second.toString()
        }
    }

    view.text = view.context.getString(R.string.game_length, minuteValue, secondValue)
}

@BindingAdapter(value = ["minutes_ago"])
fun setMinutesAgo(view: TextView, createDate: Int) {
    val currentTimeMillis = System.currentTimeMillis()
    val createTimeMillis = createDate.toLong().times(1000)

    val diffTime = currentTimeMillis.minus(createTimeMillis)

    val minutes: Long = diffTime / (1000 * 60) % 60
    val hours: Long = diffTime / (1000 * 60 * 60) % 24

    val result = if (hours != 0L) {
        view.context.getString(R.string.hour, hours.toString()).plus(
            view.context.getString(R.string.minutes, minutes.toString())
                .plus(view.context.getString(R.string.minutes_ago))
        )
    } else {
        view.context.getString(R.string.minutes, minutes.toString())
            .plus(view.context.getString(R.string.minutes_ago))
    }

    view.text = result
}

@BindingAdapter(value = ["score_badge"])
fun setOpScoreBadge(view: TextView, badge: String?) {
    badge?.let {
        if (it.isNotEmpty()) {
            view.visibility = View.VISIBLE
            view.text = it

            when (it) {
                "ACE" -> {
                    view.setBackgroundResource(R.drawable.shape_rectangle_8_periwinkle)
                }

                "MVP" -> {
                    view.setBackgroundResource(R.drawable.shape_rectangle_8_orange_yellow)
                }

                else -> {
                    view.setBackgroundResource(R.drawable.shape_rectangle_8_periwinkle)
                }
            }
        } else {
            view.visibility = View.GONE
        }
    }
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



