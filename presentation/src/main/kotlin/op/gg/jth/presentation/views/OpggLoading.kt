package op.gg.jth.presentation.views

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.content.res.ResourcesCompat
import op.gg.jth.presentation.R
import op.gg.jth.presentation.databinding.OpggProgressBarBinding

class OpggLoading(context: Context) {
    private var binding : OpggProgressBarBinding ?= null
    private var dialog: CustomDialog

    fun show(title: String = "") {
        binding?.title?.text = title
        dialog.show()
    }

    fun dismiss() {
        dialog.dismiss()
    }

    init {
        binding = OpggProgressBarBinding.inflate((context as Activity).layoutInflater)

        setColorFilter(
            binding?.progressCircular?.indeterminateDrawable!!,
            ResourcesCompat.getColor(context.resources, R.color.black, null)
        )

        dialog = CustomDialog(context)
        dialog.setContentView(binding?.root!!)
    }

    private fun setColorFilter(drawable: Drawable, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
        } else {
            @Suppress("DEPRECATION")
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }
    }

    class CustomDialog(context: Context) : Dialog(context,  android.R.style.Theme_Dialog) {
        init {
            window?.decorView?.rootView?.setBackgroundResource(android.R.color.transparent)
            window?.decorView?.setOnApplyWindowInsetsListener { _, insets ->
                insets.consumeSystemWindowInsets()
            }
        }
    }
}