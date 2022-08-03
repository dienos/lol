package recruiting_test_base.data.repository

import recruiting_test_base.data.datasource.SampleRemoteSource
import recruiting_test_base.domain.model.remote.SampleRepo
import recruiting_test_base.domain.repository.remote.SampleRepository
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val remoteSource: SampleRemoteSource,
) : SampleRepository {
    override suspend fun getSample(): List<SampleRepo> = remoteSource.getSimple()
}