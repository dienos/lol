package op.gg.jth.data.model.local

import op.gg.jth.domain.model.local.ChampionRepo

data class LocalChampion(
    val _imageUrl: String,
    val _winningRate: Float
) : ChampionRepo {
    override val imageUrl: String
        get() = _imageUrl
    override val winningRate: Float
        get() = _winningRate
}