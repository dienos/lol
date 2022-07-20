package recruiting_test_base.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import recruiting_test_base.domain.model.SampleRepo
import recruiting_test_base.domain.repository.SampleRepository

class GetSampleUseCase(private val repository: SampleRepository) {
    operator fun invoke(
        scope: CoroutineScope,
        onResult: (List<SampleRepo>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getSample()
            }
            onResult(deferred.await())
        }
    }
}