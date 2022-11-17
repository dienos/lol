package op.gg.jth.presentation.views

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import op.gg.jth.presentation.BR
import op.gg.jth.presentation.R
import op.gg.jth.presentation.databinding.MainActivityBinding
import op.gg.jth.presentation.viewmodels.MainViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding>() {
    private val _viewModel: MainViewModel by viewModels()
    private val viewModel: MainViewModel
        get() = _viewModel

    override fun getLayoutResId(): Int = R.layout.main_activity

    override fun initializeViewModel() {
        binding?.viewModel = viewModel
        binding?.lifecycleOwner = this
        viewModel.getSummoner()
        viewModel.getGames()
    }

    override fun initializeUiEvent() {

    }
}