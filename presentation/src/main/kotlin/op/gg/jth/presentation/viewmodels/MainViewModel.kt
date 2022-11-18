package op.gg.jth.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import op.gg.jth.data.extension.getWinningRate
import op.gg.jth.data.model.local.ChampionPosition
import op.gg.jth.data.model.local.LocalChampion
import op.gg.jth.data.model.local.MostWinningRateChampions
import op.gg.jth.data.model.local.RecentTwentyGames
import op.gg.jth.domain.model.remote.ChampionsRepo
import op.gg.jth.domain.model.remote.GamesRepo
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

    var needRefresh = false

    private var _summonerResponse = MutableLiveData<SummonerResponseRepo>()
    val summonerResponse: LiveData<SummonerResponseRepo> = _summonerResponse

    private var _gamesResponse = MutableLiveData<GamesResponseRepo>()
    val gamesResponse: LiveData<GamesResponseRepo> = _gamesResponse

    private var _recentTwentyGames = MutableLiveData<RecentTwentyGames>()
    val recentTwentyGames: LiveData<RecentTwentyGames> = _recentTwentyGames

    private var _mostWinningRateChampions = MutableLiveData<MostWinningRateChampions>()
    val mostWinningRateChampions: LiveData<MostWinningRateChampions> = _mostWinningRateChampions

    private var _championPosition = MutableLiveData<ChampionPosition>()
    val championPosition: LiveData<ChampionPosition> = _championPosition

    fun getSummoner() {
        updateProgress(true)

        viewModelScope.launch {
            _summonerResponse.value = getSummonerUseCase.invoke()
        }

        updateProgress(false)
    }

    fun getGames(lastMatch: Int = 0) {
        updateProgress(true)

        getGamesUseCase(lastMatch = lastMatch, scope = viewModelScope, { result ->
            updateProgress(false)
            _gamesResponse.value = result
        }, {
            updateToast(it)
            updateProgress(false)
        })
    }

    fun initGames(lastMatch: Int = 0) {
        updateProgress(true)

        getGamesUseCase(lastMatch = lastMatch, scope = viewModelScope, { result ->
            needRefresh = true
            updateProgress(false)
            _gamesResponse.value = result
            _recentTwentyGames.value = RecentTwentyGames(getRecentTwentyList(result.games))
            _mostWinningRateChampions.value =
                MostWinningRateChampions(getMostWinningRateChampions(result.champions))

            _championPosition.value = ChampionPosition(result.positions)
        }, {
            updateToast(it)
            updateProgress(false)
        })
    }

    private fun getRecentTwentyList(games: List<GamesRepo>): List<GamesRepo> =
        games.filterIndexed { index, _ ->
            index < 20
        }

    private fun getMostWinningRateChampions(champions: List<ChampionsRepo>): List<LocalChampion> {
        val result: ArrayList<LocalChampion> = arrayListOf()

        champions.sortedBy {
            val winsValue = it.wins.toFloat()
            val lossesValue = it.losses.toFloat()
            val sum = winsValue.plus(lossesValue)

            sum.getWinningRate(winsValue)
        }.toMutableList().forEach { champion ->
            if (result.size >= 2) {
                return@forEach
            }

            val winsValue = champion.wins.toFloat()
            val lossesValue = champion.losses.toFloat()
            val sum = winsValue.plus(lossesValue)

            result.add(
                LocalChampion(
                    imageUrl = champion.imageUrl,
                    winningRate = sum.getWinningRate(winsValue)
                )
            )
        }

        return result
    }
}