package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.LadderRankRepo
import op.gg.jth.domain.model.remote.LeagueRepo
import op.gg.jth.domain.model.remote.PreviousTiersRepo
import op.gg.jth.domain.model.remote.SummonerRepo

data class Summoner(
    @SerializedName("name")
    private val _name: String,

    @SerializedName("level")
    private val _level: String,

    @SerializedName("profileImageUrl")
    private val _profileImageUrl: String,

    @SerializedName("profileBorderImageUrl")
    private val _profileBorderImageUrl: String,

    @SerializedName("url")
    private val _url: String,

    @SerializedName("leagues")
    private val _leagues: List<League>,

    @SerializedName("previousTiers")
    private val _previousTiers: List<PreviousTiers>,

    @SerializedName("ladderRank")
    private val _ladderRank: LadderRank,

    @SerializedName("profileBackgroundImageUrl")
    private val _profileBackgroundImageUrl: String
) : SummonerRepo {
    override val name: String
        get() = _name

    override val level: String
        get() = _level

    override val profileImageUrl: String
        get() = _profileImageUrl

    override val profileBorderImageUrl: String
        get() = _profileBorderImageUrl

    override val url: String
        get() = _url

    override val leagues: List<LeagueRepo>
        get() = _leagues

    override val previousTiers: List<PreviousTiersRepo>
        get() = _previousTiers

    override val ladderRank: LadderRankRepo
        get() = _ladderRank

    override val profileBackgroundImageUrl: String
        get() = _profileBackgroundImageUrl
}