package op.gg.jth.data.repository

import op.gg.jth.data.datasource.SummonerRemoteSource
import op.gg.jth.data.model.remote.SummonerResponse
import op.gg.jth.domain.repository.remote.SummonerRepository
import javax.inject.Inject

class SummonerRepositoryImpl @Inject constructor(
    private val remoteSource: SummonerRemoteSource,
) : SummonerRepository {
    override suspend fun getSummoner(): SummonerResponse = remoteSource.getSummoner()
}