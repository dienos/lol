package op.gg.jth.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import op.gg.jth.domain.model.remote.GamesResponseRepo
import op.gg.jth.domain.model.remote.SummonerResponseRepo
import op.gg.jth.domain.usecase.GetGamesUseCase
import op.gg.jth.domain.usecase.GetSummonerUseCase
import op.gg.jth.presentation.BR
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSummonerUseCase: GetSummonerUseCase,
    private val getGamesUseCase: GetGamesUseCase,
) : BaseViewModel() {
    companion object {
        const val GAME_AVERAGE_TYPE_KILL = "kill"
        const val GAME_AVERAGE_TYPE_ASSIST = "assist"
        const val GAME_AVERAGE_TYPE_DEATH = "death"
    }

    var killAverage = 0.0f
    var assistAverage = 0.0f
    var deathAverage = 0.0f

    private var _summonerResponse = MutableLiveData<SummonerResponseRepo>()
    val summonerResponse: LiveData<SummonerResponseRepo> = _summonerResponse

    private var _gamesResponse = MutableLiveData<GamesResponseRepo>()
    val gamesResponse: LiveData<GamesResponseRepo> = _gamesResponse

    fun getSummoner() {
        viewModelScope.launch {
            _summonerResponse.value = getSummonerUseCase.invoke()
        }
    }

    fun getGames(lastMatch: Int = 0) {
        viewModelScope.launch {
            _gamesResponse.value = getGamesUseCase(lastMatch)
        }
    }
}