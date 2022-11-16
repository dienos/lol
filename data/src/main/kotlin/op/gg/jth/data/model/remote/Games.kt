package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.*

data class Games(
    @SerializedName("mmr")
    val _mmr : Int,

    @SerializedName("champion")
    val _champion : Champion,

    @SerializedName("spells")
    val _spells : List<Spells>,

    @SerializedName("items")
    val _items : List<Item>,

    @SerializedName("needRenew")
    val _needRenew : Boolean,

    @SerializedName("needRenew")
    val _gameId : String,

    @SerializedName("createDate")
    val _createDate : Int,

    @SerializedName("gameLength")
    val _gameLength : Int,

    @SerializedName("gameType")
    val _gameType : String,

    @SerializedName("summonerId")
    val _summonerId : String,

    @SerializedName("summonerName")
    val _summonerName : String,

    @SerializedName("tierRankShort")
    val _tierRankShort : String,

    @SerializedName("stats")
    val _stats : Stats,

    @SerializedName("mapInfo")
    val _mapInfo : Any?,

    @SerializedName("peak")
    val _peak : List<String>,

    @SerializedName("isWin")
    val _isWin : Boolean,
) : GamesRepo {
    override val champion: ChampionRepo
        get() = _champion

    override val createDate: Int
        get() = _createDate

    override val gameId: String
        get() = _gameId

    override val gameLength: Int
        get() = _gameLength

    override val gameType: String
        get() = _gameType

    override val isWin: Boolean
        get() = _isWin

    override val mapInfo: Any?
        get() = _mapInfo

    override val mmr: Int
        get() = _mmr

    override val needRenew: Boolean
        get() = _needRenew

    override val items: List<ItemRepo>
        get() = _items

    override val peak: List<String>
        get() = _peak

    override val spells: List<SpellsRepo>
        get() = _spells

    override val stats: StatsRepo
        get() = _stats

    override val summonerId: String
        get() = _summonerId

    override val summonerName: String
        get() = _summonerName

    override val tierRankShort: String
        get() = _tierRankShort
}