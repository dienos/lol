package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.GamesRepo
import op.gg.jth.domain.model.remote.GamesResponseRepo

data class GamesResponse(
    @SerializedName("games")
    val _games: List<Games>
) : GamesResponseRepo {
    override val games: List<GamesRepo>
        get() = _games
}