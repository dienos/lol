package op.gg.jth.domain.model.remote

interface PositionsRepo {
    val games: Int
    val wins: Int
    val losses: Int
    val position: String
    val positionName: String
}