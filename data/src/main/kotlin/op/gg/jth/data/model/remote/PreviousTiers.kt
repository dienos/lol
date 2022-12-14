package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.PreviousTiersRepo

data class PreviousTiers (
    @SerializedName("name")
    val _name: String,

    @SerializedName("tier")
    val _tier: String,

    @SerializedName("tierDivision")
    val _tierDivision: String,

    @SerializedName("string")
    val _string: String,

    @SerializedName("shortString")
    val _shortString: String,

    @SerializedName("division")
    val _division: String,

    @SerializedName("imageUrl")
    val _imageUrl: String,

    @SerializedName("lp")
    val _lp: Int,

    @SerializedName("tierRankPoint")
    val _tierRankPoint: Int,

    @SerializedName("season")
    val _season: Int
) : PreviousTiersRepo {
    override val division: String
        get() = _division

    override val lp: Int
        get() = _lp

    override val imageUrl: String
        get() = _imageUrl

    override val tierDivision: String
        get() = _tierDivision

    override val name: String
        get() = _name

    override val season: Int
        get() = _season

    override val shortString: String
        get() = _shortString

    override val string: String
        get() = _string

    override val tier: String
        get() = _tier

    override val tierRankPoint: Int
        get() = _tierRankPoint
}