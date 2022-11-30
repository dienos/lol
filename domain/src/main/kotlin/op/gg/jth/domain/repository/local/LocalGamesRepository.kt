package op.gg.jth.domain.repository.local

import op.gg.jth.domain.model.local.ChampionRepo
import op.gg.jth.domain.model.local.MostWinningRateChampionsRepo
import op.gg.jth.domain.model.local.RecentTwentyGamesRepo
import op.gg.jth.domain.model.remote.ChampionsRepo
import op.gg.jth.domain.model.remote.GamesResponseRepo

interface LocalGamesRepository {
    fun getRecentTwentyGames(games: GamesResponseRepo): RecentTwentyGamesRepo
    fun getMostWinningRateChampions(champions: List<ChampionsRepo>) : MostWinningRateChampionsRepo
}