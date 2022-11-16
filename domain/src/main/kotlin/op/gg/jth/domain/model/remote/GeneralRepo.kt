package op.gg.jth.domain.model.remote

interface GeneralRepo {
    val kill: Int
    val death: Int
    val assist: Int
    val kdaString : String
    val cs : Int
    val csPerMin : Int
    val contributionForKillRate : String
    val goldEarned : Int
    val totalDamageDealtToChampions : Int
    val largestMultiKillString : String
    val opScoreBadge : String
}