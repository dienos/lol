package op.gg.jth.domain.repository.local

import op.gg.jth.domain.model.local.LocalSampleRepo

interface LocalSampleRepository {
    suspend fun getLocalSample() : List<LocalSampleRepo>
}