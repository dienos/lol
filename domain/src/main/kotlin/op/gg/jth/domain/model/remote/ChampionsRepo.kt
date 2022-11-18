package op.gg.jth.domain.model.remote

interface ChampionsRepo {
    val id : Int
    val key : String
    val name : String
    val imageUrl : String
    val games : Int
    val kills : Int
    val deaths : Int
    val assists : Int
    val wins : Int
    val losses : Int
}