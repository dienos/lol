package op.gg.jth.data.repository.local

import op.gg.jth.data.datasource.local.GamesLocalSource
import op.gg.jth.data.model.local.RecentTwentyGames
import op.gg.jth.domain.model.local.ChampionRepo
import op.gg.jth.domain.model.local.MostWinningRateChampionsRepo
import op.gg.jth.domain.model.local.RecentTwentyGamesRepo
import op.gg.jth.domain.model.remote.ChampionsRepo
import op.gg.jth.domain.model.remote.GamesResponseRepo
import op.gg.jth.domain.repository.local.LocalGamesRepository
import javax.inject.Inject

class LocalGamesRepositoryImpl @Inject constructor(
    private val localSource: GamesLocalSource,
) : LocalGamesRepository {

    override fun getRecentTwentyGames(games: GamesResponseRepo): RecentTwentyGames =
        localSource.getRecentTwentyGames(games)

    override fun getMostWinningRateChampions(champions: List<ChampionsRepo>): MostWinningRateChampionsRepo
      =  localSource.getMostWinningRateChampions(champions)
}