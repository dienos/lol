package op.gg.jth.domain.usecase

import op.gg.jth.domain.model.remote.GamesResponseRepo
import op.gg.jth.domain.repository.remote.GamesRepository

class GetGamesUseCase(private val repository: GamesRepository) {
    suspend operator fun invoke(
        lastMatch: Int
    ): GamesResponseRepo {
        return repository.getGames(lastMatch)
    }
}