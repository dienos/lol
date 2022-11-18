package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.ChampionsRepo

data class Champions(
    @SerializedName("id")
    val _id: Int,

    @SerializedName("key")
    val _key: String,

    @SerializedName("name")
    val _name: String,

    @SerializedName("imageUrl")
    val _imageUrl: String,

    @SerializedName("games")
    val _games: Int,

    @SerializedName("kills")
    val _kills: Int,

    @SerializedName("deaths")
    val _deaths: Int,

    @SerializedName("assists")
    val _assists: Int,

    @SerializedName("wins")
    val _wins: Int,

    @SerializedName("losses")
    val _losses: Int
) : ChampionsRepo {
    override val assists: Int
        get() = _assists
    override val games: Int
        get() = _games
    override val deaths: Int
        get() = _deaths
    override val id: Int
        get() = _id
    override val imageUrl: String
        get() = _imageUrl
    override val key: String
        get() = _key
    override val kills: Int
        get() = _kills
    override val losses: Int
        get() = _losses
    override val name: String
        get() = _name
    override val wins: Int
        get() = _wins
}