package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.PositionsRepo

data class Positions(
    @SerializedName("games")
    val _games: Int,

    @SerializedName("wins")
    val _wins: Int,

    @SerializedName("losses")
    val _losses: Int,

    @SerializedName("position")
    val _position: String,

    @SerializedName("positionName")
    val _positionName: String
) : PositionsRepo {
    override val games: Int
        get() = _games

    override val losses: Int
        get() = _losses

    override val position: String
        get() = _position

    override val positionName: String
        get() = _positionName

    override val wins: Int
        get() = _wins
}