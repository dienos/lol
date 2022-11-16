package op.gg.jth.data.repository

import op.gg.jth.data.datasource.GamesRemoteSource
import op.gg.jth.domain.model.remote.GamesResponseRepo
import op.gg.jth.domain.repository.remote.GamesRepository
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val remoteSource: GamesRemoteSource,
) : GamesRepository {
    override suspend fun getGames(lastMatch: Int): GamesResponseRepo =
        remoteSource.getGames(lastMatch)
}