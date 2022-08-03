package recruiting_test_base.data.datasource

import recruiting_test_base.data.db.dao.SampleDao
import recruiting_test_base.data.model.LocalSampleRepoRes
import javax.inject.Inject

interface SampleLocalSource {
    suspend fun getLocalSimple(): List<LocalSampleRepoRes>
}

class SampleLocalSourceImpl @Inject constructor(
    private val dao: SampleDao
) : SampleLocalSource {
    override suspend fun getLocalSimple(): List<LocalSampleRepoRes> = dao.getSamples()
}