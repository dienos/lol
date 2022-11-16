package op.gg.jth.domain.model.remote

interface StatsRepo {
    val general : GeneralRepo
    val ward : WardRepo
}