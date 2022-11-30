package op.gg.jth.domain.usecase

import op.gg.jth.domain.model.local.RecentTwentyGamesRepo
import op.gg.jth.domain.model.remote.GamesResponseRepo
import op.gg.jth.domain.repository.local.LocalGamesRepository

class GetRecentTwentyGamesUseCase(private val repository: LocalGamesRepository) {
    operator fun invoke(
        games: GamesResponseRepo
    ): RecentTwentyGamesRepo = repository.getRecentTwentyGames(games)
}