package op.gg.jth.domain.repository.remote

import op.gg.jth.domain.model.remote.SummonerResponseRepo

interface SummonerRepository {
    suspend fun getSummoner() : SummonerResponseRepo
}