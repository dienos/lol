package recruiting_test_base.domain.usecase

import recruiting_test_base.domain.model.remote.SampleRepo
import recruiting_test_base.domain.repository.remote.SampleRepository

class GetSampleUseCase(private val repository: SampleRepository) {
    suspend operator fun invoke(
    ): List<SampleRepo> {
        return repository.getSample()
    }
}