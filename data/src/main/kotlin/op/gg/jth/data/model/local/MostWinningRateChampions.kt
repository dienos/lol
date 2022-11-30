package op.gg.jth.data.model.local

import op.gg.jth.domain.model.local.ChampionRepo
import op.gg.jth.domain.model.local.MostWinningRateChampionsRepo

data class MostWinningRateChampions(val _champions: List<LocalChampion>) :
    MostWinningRateChampionsRepo {
    override val champions: List<ChampionRepo>
        get() = _champions
}