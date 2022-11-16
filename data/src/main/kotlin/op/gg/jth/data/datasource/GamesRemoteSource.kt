package op.gg.jth.data.datasource

import op.gg.jth.data.api.OpggService
import op.gg.jth.data.model.remote.GamesResponse
import op.gg.jth.data.model.remote.SummonerResponse
import javax.inject.Inject

interface GamesRemoteSource {
    suspend fun getGames(lastMatch: Int): GamesResponse
}

class GamesRemoteSourceImpl @Inject constructor(
    private val service: OpggService
) : GamesRemoteSource {
    override suspend fun getGames(lastMatch: Int): GamesResponse = service.getGames(lastMatch)
}