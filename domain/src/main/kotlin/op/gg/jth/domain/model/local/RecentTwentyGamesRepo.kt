package op.gg.jth.domain.model.local

import op.gg.jth.domain.model.remote.GamesRepo

interface RecentTwentyGamesRepo {
    val games: List<GamesRepo>
}