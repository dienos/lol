package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.ChampionsRepo
import op.gg.jth.domain.model.remote.GamesRepo
import op.gg.jth.domain.model.remote.GamesResponseRepo
import op.gg.jth.domain.model.remote.PositionsRepo

data class GamesResponse(
    @SerializedName("games")
    val _games: List<Games>,

    @SerializedName("champions")
    val _champions: List<Champions>,

    @SerializedName("positions")
    val _positions: List<Positions>) : GamesResponseRepo {
    override val games: List<GamesRepo>
        get() = _games

    override val champions: List<ChampionsRepo>
        get() = _champions

    override val positions: List<PositionsRepo>
        get() = _positions
}