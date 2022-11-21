package op.gg.jth.presentation.views

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import op.gg.jth.presentation.R

class OpggDialogFragment(
    private val message: String = "",
    private val onPositiveButtonClick: () -> Unit = {}
) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(message)
                .setPositiveButton(
                    R.string.confirm
                ) { _, _ ->
                    dismiss()
                    onPositiveButtonClick()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}