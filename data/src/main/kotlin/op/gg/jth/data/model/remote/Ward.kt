package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.WardRepo

data class Ward(
    @SerializedName("sightWardsBought")
    val _sightWardsBought: Int,

    @SerializedName("visionWardsBought")
    val _visionWardsBought: Int
) : WardRepo {
    override val sightWardsBought: Int
        get() = _sightWardsBought

    override val visionWardsBought: Int
        get() = _visionWardsBought
}
