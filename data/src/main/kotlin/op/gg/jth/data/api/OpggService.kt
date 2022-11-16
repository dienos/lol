package op.gg.jth.data.api

import op.gg.jth.data.model.remote.GamesResponse
import op.gg.jth.data.model.remote.SummonerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpggService {
    @GET(SUMMONER)
    suspend fun getSummoner(): SummonerResponse

    @GET(GAMES)
    suspend fun getGames(@Query("lastMatch") lastMatch: Int): GamesResponse
}