package op.gg.jth.data.datasource

import op.gg.jth.data.api.OpggService
import op.gg.jth.data.model.remote.GamesResponse
import op.gg.jth.data.model.remote.SummonerResponse
import javax.inject.Inject

interface SummonerRemoteSource {
    suspend fun getSummoner(): SummonerResponse
}

class SummonerRemoteSourceImpl @Inject constructor(
    private val service: OpggService
) : SummonerRemoteSource {
    override suspend fun getSummoner(): SummonerResponse = service.getSummoner()
}