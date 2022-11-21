package op.gg.jth.presentation

import android.annotation.SuppressLint
import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import op.gg.jth.presentation.utils.NetworkUtil

@HiltAndroidApp
class OpggApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        var networkUtil : NetworkUtil? = null
    }

    override fun onCreate() {
        super.onCreate()
    }
}