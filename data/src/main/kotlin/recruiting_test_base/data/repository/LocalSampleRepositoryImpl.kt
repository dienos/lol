package recruiting_test_base.data.repository

import recruiting_test_base.data.datasource.SampleLocalSource
import recruiting_test_base.domain.model.local.LocalSampleRepo
import recruiting_test_base.domain.repository.local.LocalSampleRepository
import javax.inject.Inject

class LocalSampleRepositoryImpl @Inject constructor(
    private val localSource: SampleLocalSource,
) : LocalSampleRepository {
    override suspend fun getLocalSample(): List<LocalSampleRepo> =  localSource.getLocalSimple()
}