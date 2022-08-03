package recruiting_test_base.domain.repository.local

import recruiting_test_base.domain.model.local.LocalSampleRepo

interface LocalSampleRepository {
    suspend fun getLocalSample() : List<LocalSampleRepo>
}