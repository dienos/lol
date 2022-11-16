package op.gg.jth.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OpggApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}