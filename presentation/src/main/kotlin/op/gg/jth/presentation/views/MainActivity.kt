package op.gg.jth.presentation.views

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import op.gg.jth.presentation.R
import op.gg.jth.presentation.databinding.MainActivityBinding
import op.gg.jth.presentation.viewmodels.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding>() {
    private lateinit var progress: OpggLoading

    private val _viewModel: MainViewModel by viewModels()
    private val viewModel: MainViewModel
        get() = _viewModel

    override fun getLayoutResId(): Int = R.layout.main_activity

    override fun initializeViewModel() {
        progress = OpggLoading(this)
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
        viewModel.getSummoner()
        viewModel.initGames()
    }

    override fun initializeUiEvent() {
        binding?.lifecycleOwner?.lifecycleScope?.launch {
            viewModel.progressFlow.collect { isShowing ->

                if (isShowing) {
                    progress.show()
                } else {
                    progress.dismiss()
                }
            }
        }
    }
}