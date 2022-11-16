package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.GeneralRepo

data class General(
    @SerializedName("kill")
    val _kill: Int,

    @SerializedName("death")
    val _death: Int,

    @SerializedName("assist")
    val _assist: Int,

    @SerializedName("kdaString")
    val _kdaString : String,

    @SerializedName("cs")
    val _cs : Int,

    @SerializedName("csPerMin")
    val _csPerMin : Int,

    @SerializedName("contributionForKillRate")
    val _contributionForKillRate : String,

    @SerializedName("goldEarned")
    val _goldEarned : Int,

    @SerializedName("totalDamageDealtToChampions")
    val _totalDamageDealtToChampions : Int,

    @SerializedName("largestMultiKillString")
    val _largestMultiKillString : String,

    @SerializedName("opScoreBadge")
    val _opScoreBadge : String
) : GeneralRepo {
    override val assist: Int
        get() = _assist

    override val contributionForKillRate: String
        get() = _contributionForKillRate

    override val csPerMin: Int
        get() = _csPerMin

    override val cs: Int
        get() = _cs

    override val death: Int
        get() = _death

    override val goldEarned: Int
        get() = _goldEarned

    override val kdaString: String
        get() = _kdaString

    override val kill: Int
        get() = _kill

    override val largestMultiKillString: String
        get() = _largestMultiKillString

    override val opScoreBadge: String
        get() = _opScoreBadge

    override val totalDamageDealtToChampions: Int
        get() = _totalDamageDealtToChampions
}