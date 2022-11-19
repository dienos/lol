package op.gg.jth.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel : ViewModel() {
    enum class ShimmerType {
        TYPE_SUMMONER,
        TYPE_RECENT_GAME,
        TYPE_GAMES
    }

    data class ShimmerFlow(
        var type: ShimmerType = ShimmerType.TYPE_SUMMONER,
        var show: Boolean ?= null
    )

    private val _progress = MutableStateFlow(false)
    val progressFlow = _progress.asStateFlow()

    private val _toast = MutableStateFlow("")
    val toastFlow = _toast.asStateFlow()

    fun updateProgress(show: Boolean) {
        _progress.value = show
    }

    fun updateToast(text: String) {
        _toast.value = text
    }
}