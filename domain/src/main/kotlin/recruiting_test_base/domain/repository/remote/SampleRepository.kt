package recruiting_test_base.domain.repository.remote

import recruiting_test_base.domain.model.remote.SampleRepo

interface SampleRepository {
    suspend fun getSample() : List<SampleRepo>
}