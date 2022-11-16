package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.ItemRepo

data class Item(
    @SerializedName("imageUrl")
    val _imageUrl: String
) : ItemRepo {
    override val imageUrl: String
        get() = _imageUrl
}