package op.gg.jth.domain.model.remote

interface LeagueRepo {
    val hasResults : String
    val wins: String
    val losses: String
    val tierRank : TierRankRepo
}