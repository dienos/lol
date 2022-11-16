package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.GeneralRepo
import op.gg.jth.domain.model.remote.StatsRepo
import op.gg.jth.domain.model.remote.WardRepo

data class Stats(
    @SerializedName("general")
    val _general: General,

    @SerializedName("ward")
    val _ward: Ward
) : StatsRepo {
    override val general: GeneralRepo
        get() = _general

    override val ward: WardRepo
        get() = _ward
}
