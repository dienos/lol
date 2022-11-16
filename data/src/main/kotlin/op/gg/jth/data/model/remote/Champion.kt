package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.ChampionRepo

data class Champion(
    @SerializedName("imageUrl")
    val _imageUrl : String,

    @SerializedName("level")
    val _level : Int
) : ChampionRepo {
    override val imageUrl: String
        get() = _imageUrl

    override val level: Int
        get() = _level
}