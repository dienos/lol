package op.gg.jth.presentation.extensions

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import op.gg.jth.presentation.views.OpggDialogFragment

fun Activity.isActivityAvailable(): Boolean {
    return !isFinishing
}

fun Activity.showDlg(message : String) {
    if (this is FragmentActivity && this.isActivityAvailable()) {
        val fragmentManager = supportFragmentManager
        OpggDialogFragment(
            message = message,
            onPositiveButtonClick = {
                finish()
            }).show(fragmentManager, "dlg")
    }
}