package op.gg.jth.data.model.remote

import com.google.gson.annotations.SerializedName
import op.gg.jth.domain.model.remote.SummonerRepo
import op.gg.jth.domain.model.remote.SummonerResponseRepo

data class SummonerResponse(
    @SerializedName("summoner")
    private val _summoner: Summoner
) : SummonerResponseRepo {
    override val summoner: SummonerRepo
        get() = _summoner
}
