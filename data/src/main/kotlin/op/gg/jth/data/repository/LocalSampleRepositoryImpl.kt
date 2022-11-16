package op.gg.jth.data.repository

import op.gg.jth.data.datasource.SampleLocalSource
import op.gg.jth.domain.model.local.LocalSampleRepo
import op.gg.jth.domain.repository.local.LocalSampleRepository
import javax.inject.Inject

class LocalSampleRepositoryImpl @Inject constructor(
    private val localSource: SampleLocalSource,
) : LocalSampleRepository {
    override suspend fun getLocalSample(): List<LocalSampleRepo> =  localSource.getLocalSimple()
}