package op.gg.jth.domain.usecase

import op.gg.jth.domain.model.local.MostWinningRateChampionsRepo
import op.gg.jth.domain.model.remote.ChampionsRepo
import op.gg.jth.domain.repository.local.LocalGamesRepository

class GetMostWinningRateChampionsUseCase(private val repository: LocalGamesRepository) {
    operator fun invoke(
        champions: List<ChampionsRepo>
    ): MostWinningRateChampionsRepo = repository.getMostWinningRateChampions(champions)
}