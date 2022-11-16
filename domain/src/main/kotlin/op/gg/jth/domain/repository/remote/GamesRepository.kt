package op.gg.jth.domain.repository.remote

import op.gg.jth.domain.model.remote.GamesResponseRepo

interface GamesRepository {
    suspend fun getGames(lastMatch: Int) : GamesResponseRepo
}