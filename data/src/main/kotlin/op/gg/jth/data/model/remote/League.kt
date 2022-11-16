package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.LeagueRepo
import op.gg.jth.domain.model.remote.TierRankRepo

data class League (
    @SerializedName("hasResults")
    val _hasResults : String,

    @SerializedName("wins")
    val _wins: String,

    @SerializedName("losses")
    val _losses: String,

    @SerializedName("tierRank")
    val _tierRank : TierRank,
) : LeagueRepo {
    override val hasResults: String
        get() = _hasResults

    override val losses: String
        get() = _losses

    override val tierRank: TierRankRepo
        get() = _tierRank

    override val wins: String
        get() = _wins
}