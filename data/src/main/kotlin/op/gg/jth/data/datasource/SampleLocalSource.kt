package op.gg.jth.data.datasource

import op.gg.jth.data.db.dao.SampleDao
import op.gg.jth.data.model.local.LocalSampleRepoRes
import javax.inject.Inject

interface SampleLocalSource {
    suspend fun getLocalSimple(): List<LocalSampleRepoRes>
}

class SampleLocalSourceImpl @Inject constructor(
    private val dao: SampleDao
) : SampleLocalSource {
    override suspend fun getLocalSimple(): List<LocalSampleRepoRes> = dao.getSamples()
}