package op.gg.jth.domain.usecase

import op.gg.jth.domain.model.remote.SummonerResponseRepo
import op.gg.jth.domain.repository.remote.SummonerRepository

class GetSummonerUseCase(private val repository: SummonerRepository) {
    suspend operator fun invoke(
    ): SummonerResponseRepo {
        return repository.getSummoner()
    }
}