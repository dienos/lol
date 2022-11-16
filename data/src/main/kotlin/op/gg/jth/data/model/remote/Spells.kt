package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.SpellsRepo

data class Spells(
    @SerializedName("imageUrl")
    val _imageUrl: String
) : SpellsRepo {
    override val imageUrl: String
        get() = _imageUrl
}