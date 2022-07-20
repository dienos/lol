package recruiting_test_base.data.datasource

import recruiting_test_base.data.model.SampleRepoRes
import recruiting_test_base.domain.model.SampleRepo
import recruiting_test_base.domain.repository.SampleRepository
import javax.inject.Inject

interface SampleRemoteSource {
    suspend fun getSimple(): List<SampleRepoRes>
}

class SampleRemoteSourceImpl @Inject constructor(
    private val sampleService: SampleRemoteSource
) : SampleRepository {
    override suspend fun sample(): List<SampleRepo> = sampleService.getSimple()
}