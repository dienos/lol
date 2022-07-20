package recruiting_test_base.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import recruiting_test_base.domain.model.SampleRepo
import recruiting_test_base.domain.usecase.GetSampleUseCase
import androidx.lifecycle.viewModelScope
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val getSampleUseCase: GetSampleUseCase
) : BaseViewModel() {

    private var _sampleData = MutableLiveData<List<SampleRepo>>()
    val sampleRepository : LiveData<List<SampleRepo>> = _sampleData

    fun getSimpleData() {
        getSampleUseCase(viewModelScope) {
            _sampleData.value = it
        }
    }
}