package op.gg.jth.domain.model.remote

interface PreviousTiersRepo {
    val name: String
    val tier: String
    val tierDivision: String
    val string: String
    val shortString: String
    val division: String
    val imageUrl: String
    val lp: Int
    val tierRankPoint: Int
    val season: Int
}