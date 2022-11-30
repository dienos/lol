package op.gg.jth.data.model.local

import op.gg.jth.domain.model.local.RecentTwentyGamesRepo
import op.gg.jth.domain.model.remote.GamesRepo

data class RecentTwentyGames(val _games: List<GamesRepo>) : RecentTwentyGamesRepo {
    override val games: List<GamesRepo>
        get() = _games
}