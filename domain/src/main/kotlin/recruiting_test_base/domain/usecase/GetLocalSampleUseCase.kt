package recruiting_test_base.domain.usecase

import recruiting_test_base.domain.model.local.LocalSampleRepo
import recruiting_test_base.domain.repository.local.LocalSampleRepository

class GetLocalSampleUseCase(private val repository: LocalSampleRepository) {
    suspend operator fun invoke(
    ): List<LocalSampleRepo> {
        return repository.getLocalSample()
    }
}