package recruiting_test_base.data.api

import recruiting_test_base.data.model.SampleRepoRes
import retrofit2.http.GET

interface SampleService {
    @GET("sample")
    suspend fun getSample() : List<SampleRepoRes>
}