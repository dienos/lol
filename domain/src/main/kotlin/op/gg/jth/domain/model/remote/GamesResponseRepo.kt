package op.gg.jth.domain.model.remote

interface GamesResponseRepo {
    val games : List<GamesRepo>
    val champions : List<ChampionsRepo>
    val positions : List<PositionsRepo>
}