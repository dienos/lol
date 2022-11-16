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
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSummonerUseCase: GetSummonerUseCase,
    private val getGamesUseCase: GetGamesUseCase,
) : BaseViewModel() {

    private var _summonerResponse = MutableLiveData<SummonerResponseRepo>()
    val summonerResponse: LiveData<SummonerResponseRepo> = _summonerResponse

    private var _gamesResponse = MutableLiveData<GamesResponseRepo>()
    val gamesResponse: LiveData<GamesResponseRepo> = _gamesResponse

    fun getSummoner() {
        viewModelScope.launch {
            _summonerResponse.value = getSummonerUseCase.invoke()
        }
    }

    fun getGames(lastMatch: Int) {
        viewModelScope.launch {
            _gamesResponse.value = getGamesUseCase(lastMatch)
        }
    }
}