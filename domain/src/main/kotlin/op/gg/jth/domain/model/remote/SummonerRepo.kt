package op.gg.jth.domain.model.remote

interface SummonerRepo {
    val name: String
    val level: String
    val profileImageUrl: String
    val profileBorderImageUrl: String
    val url: String
    val leagues : List<LeagueRepo>
    val previousTiers : List<PreviousTiersRepo>
    val ladderRank : LadderRankRepo
    val profileBackgroundImageUrl : String
}