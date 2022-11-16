package op.gg.jth.domain.model.remote

interface GamesRepo {
    val mmr : Int
    val champion : ChampionRepo
    val spells : List<SpellsRepo>
    val items : List<ItemRepo>
    val needRenew : Boolean
    val gameId : String
    val createDate : Int
    val gameLength : Int
    val gameType : String
    val summonerId : String
    val summonerName : String
    val tierRankShort : String
    val stats : StatsRepo
    val mapInfo : Any?
    val peak : List<String>
    val isWin : Boolean
}