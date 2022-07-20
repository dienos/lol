package recruiting_test_base.domain.repository

import recruiting_test_base.domain.model.SampleRepo

interface SampleRepository {
    suspend fun sample() : List<SampleRepo>
}