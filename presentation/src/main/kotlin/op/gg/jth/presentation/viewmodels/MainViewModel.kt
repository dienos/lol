package op.gg.jth.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import op.gg.jth.data.model.local.*
import op.gg.jth.domain.model.local.MostWinningRateChampionsRepo
import op.gg.jth.domain.model.local.RecentTwentyGamesRepo
import op.gg.jth.domain.model.remote.GamesResponseRepo
import op.gg.jth.domain.model.remote.SummonerResponseRepo
import op.gg.jth.domain.usecase.GetGamesUseCase
import op.gg.jth.domain.usecase.GetMostWinningRateChampionsUseCase
import op.gg.jth.domain.usecase.GetRecentTwentyGamesUseCase
import op.gg.jth.domain.usecase.GetSummonerUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSummonerUseCase: GetSummonerUseCase,
    private val getGamesUseCase: GetGamesUseCase,
    private val getRecentTwentyGamesUseCase : GetRecentTwentyGamesUseCase,
    private val getMostWinningRateChampionsUseCase : GetMostWinningRateChampionsUseCase,
) : BaseViewModel() {
    companion object {
        const val GAME_AVERAGE_TYPE_KILL = "kill"
        const val GAME_AVERAGE_TYPE_ASSIST = "assist"
        const val GAME_AVERAGE_TYPE_DEATH = "death"
        const val IMAGE_TYPE_CIRCLE = "circle"
        const val IMAGE_TYPE_DEFAULT = "default"

        const val POSITION_SUP = "Support"
        const val POSITION_JNG = "Jungle"
        const val POSITION_ADC = "Bottom"
        const val POSITION_TOP = "Top"
        const val POSITION_MID = "Middle"
    }

    private val _summonerShimmerFlow = MutableStateFlow(false)
    val summonerShimmerFlow = _summonerShimmerFlow.asStateFlow()

    private val _recentGameShimmerFlow = MutableStateFlow(false)
    val recentGameShimmerFlow = _recentGameShimmerFlow.asStateFlow()

    private val _gamesShimmerFlow = MutableStateFlow(false)
    val gamesShimmerFlow = _gamesShimmerFlow.asStateFlow()

    var needRefresh = false

    private var _summonerResponse = MutableLiveData<SummonerResponseRepo>()
    val summonerResponse: LiveData<SummonerResponseRepo> = _summonerResponse

    private var _gamesResponse = MutableLiveData<GamesResponseRepo>()
    val gamesResponse: LiveData<GamesResponseRepo> = _gamesResponse

    private var _recentTwentyGames = MutableLiveData<RecentTwentyGamesRepo>()
    val recentTwentyGames: LiveData<RecentTwentyGamesRepo> = _recentTwentyGames

    private var _mostWinningRateChampions = MutableLiveData<MostWinningRateChampionsRepo>()
    val mostWinningRateChampions: LiveData<MostWinningRateChampionsRepo> = _mostWinningRateChampions

    private var _championPosition = MutableLiveData<ChampionPosition>()
    val championPosition: LiveData<ChampionPosition> = _championPosition

    fun getSummoner() {
        updateProgress(true)
        updateSummonerShimmer(true)

        viewModelScope.launch {
            _summonerResponse.value = getSummonerUseCase.invoke()
        }

        updateProgress(false)
        updateSummonerShimmer(false)
    }

    fun getGames(lastMatch: Int = 0) {
        updateProgress(true)
        updateGamesShimmer(true)

        getGamesUseCase(lastMatch = lastMatch, scope = viewModelScope, { result ->
            updateProgress(false)
            updateGamesShimmer(false)
            _gamesResponse.value = result
        }, {
            updateToast(it)
            updateProgress(false)
            updateGamesShimmer(false)
        })
    }

    fun initGames(lastMatch: Int = 0) {
        updateProgress(true)
        updateRecentGameShimmer(true)
        updateGamesShimmer(true)

        getGamesUseCase(lastMatch = lastMatch, scope = viewModelScope, { result ->
            needRefresh = true

            updateProgress(false)
            updateRecentGameShimmer(false)
            updateGamesShimmer(false)

            _gamesResponse.value = result
            _recentTwentyGames.value = getRecentTwentyGamesUseCase(result)
            _mostWinningRateChampions.value = getMostWinningRateChampionsUseCase(result.champions)
            _championPosition.value = ChampionPosition(result.positions)
        }, {
            updateToast(it)
            updateRecentGameShimmer(false)
            updateGamesShimmer(false)
            updateProgress(false)
        })
    }

    private fun updateSummonerShimmer(flow: Boolean) {
        _summonerShimmerFlow.value = flow
    }

    private fun updateRecentGameShimmer(flow: Boolean) {
        _recentGameShimmerFlow.value = flow
    }

    private fun updateGamesShimmer(flow: Boolean) {
        _gamesShimmerFlow.value = flow
    }
}