package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.LadderRankRepo

data class LadderRank(
    @SerializedName("rank")
    val _rank: Int,

    @SerializedName("rankPercentOfTop")
    val _rankPercentOfTop: Int,
) : LadderRankRepo {
    override val rank: Int
        get() = _rank

    override val rankPercentOfTop: Int
        get() = _rankPercentOfTop
}