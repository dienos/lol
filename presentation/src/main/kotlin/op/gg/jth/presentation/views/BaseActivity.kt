package op.gg.jth.presentation.views

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import op.gg.jth.presentation.OpggApplication.Companion.networkUtil

abstract class BaseActivity<T : ViewDataBinding?> : AppCompatActivity() {
    @LayoutRes
    abstract fun getLayoutResId(): Int
    abstract fun initializeViewModel()
    abstract fun initializeUiEvent()

    var binding: T? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        networkUtil?.let {
            it.setCurrentContext(this)
        }

        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        initializeViewModel()
        initializeUiEvent()
    }

    override fun onStop() {
        super.onStop()
        networkUtil?.terminateNetworkCallback(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        networkUtil = null
    }
}