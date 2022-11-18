package op.gg.jth.data.extension

import android.util.Log

fun Float.getWinningRate(wins: Float): Float {
    Log.i("jth", "getMostWinningRateChampions_rate :" + wins.div(this).times(100))
    return wins.div(this).times(100)
}