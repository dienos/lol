package recruiting_test_base.data.datasource

import recruiting_test_base.data.api.SampleService
import recruiting_test_base.data.model.SampleRepoRes
import javax.inject.Inject

interface SampleRemoteSource {
    suspend fun getSimple(): List<SampleRepoRes>
}

class SampleRemoteSourceImpl @Inject constructor(
    private val sampleService: SampleService
) : SampleRemoteSource {
    override suspend fun getSimple(): List<SampleRepoRes> = sampleService.getSample()
}