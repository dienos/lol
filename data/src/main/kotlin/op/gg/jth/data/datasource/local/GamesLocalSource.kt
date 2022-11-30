package op.gg.jth.data.datasource.local

import op.gg.jth.data.api.OpggService
import op.gg.jth.data.extension.getWinningRate
import op.gg.jth.data.model.local.LocalChampion
import op.gg.jth.data.model.local.MostWinningRateChampions
import op.gg.jth.data.model.local.RecentTwentyGames
import op.gg.jth.domain.model.local.MostWinningRateChampionsRepo
import op.gg.jth.domain.model.remote.ChampionsRepo
import op.gg.jth.domain.model.remote.GamesResponseRepo
import javax.inject.Inject

interface GamesLocalSource {
    fun getRecentTwentyGames(gamesData: GamesResponseRepo): RecentTwentyGames
    fun getMostWinningRateChampions(champions: List<ChampionsRepo>): MostWinningRateChampionsRepo
}

class GamesLocalSourceImpl @Inject constructor(
    private val service: OpggService
) : GamesLocalSource {
    override fun getRecentTwentyGames(gamesData: GamesResponseRepo): RecentTwentyGames {
        return RecentTwentyGames(gamesData.games.filterIndexed { index, _ ->
            index < 20
        })
    }

    override fun getMostWinningRateChampions(champions: List<ChampionsRepo>): MostWinningRateChampionsRepo {
        val result: ArrayList<LocalChampion> = arrayListOf()

        champions.sortedBy {
            val winsValue = it.wins.toFloat()
            val lossesValue = it.losses.toFloat()
            val sum = winsValue.plus(lossesValue)

            sum.getWinningRate(winsValue)
        }.toMutableList().forEach { champion ->
            if (result.size >= 2) {
                return@forEach
            }

            val winsValue = champion.wins.toFloat()
            val lossesValue = champion.losses.toFloat()
            val sum = winsValue.plus(lossesValue)

            result.add(
                LocalChampion(
                    champion.imageUrl,
                    sum.getWinningRate(winsValue)
                )
            )
        }

        return MostWinningRateChampions(result)
    }
}