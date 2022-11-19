package op.gg.jth.presentation.views

import android.os.Handler
import android.os.Looper
import android.view.View
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

        binding?.lifecycleOwner?.lifecycleScope?.launch {
            viewModel.summonerShimmerFlow.collect { show ->
                if (show) {
                    binding?.llSummonersShimmer?.root?.visibility = View.VISIBLE
                    binding?.summonersShimmer?.showShimmer(true)
                } else {
                    Handler(Looper.getMainLooper()).postDelayed(
                        {
                            binding?.summonersShimmer?.stopShimmer()
                            binding?.summonersShimmer?.hideShimmer()
                            binding?.llSummonersShimmer?.root?.visibility = View.GONE
                        }, 1000
                    )

                }
            }
        }

        binding?.lifecycleOwner?.lifecycleScope?.launch {
            viewModel.recentGameShimmerFlow.collect { show ->
                if (show) {
                    binding?.llRecentGameShimmer?.root?.visibility = View.VISIBLE
                    binding?.recentGameShimmer?.showShimmer(true)
                } else {
                    Handler(Looper.getMainLooper()).postDelayed(
                        {
                            binding?.recentGameShimmer?.stopShimmer()
                            binding?.recentGameShimmer?.hideShimmer()
                            binding?.llRecentGameShimmer?.root?.visibility = View.GONE
                        }, 1000
                    )
                }
            }
        }

        binding?.lifecycleOwner?.lifecycleScope?.launch {
            viewModel.gamesShimmerFlow.collect { show ->
                if (show) {
                    binding?.llGamesShimmer?.root?.visibility = View.VISIBLE
                    binding?.gamesShimmer?.showShimmer(true)
                } else {
                    Handler(Looper.getMainLooper()).postDelayed(
                        {
                            binding?.gamesShimmer?.stopShimmer()
                            binding?.gamesShimmer?.hideShimmer()
                            binding?.llGamesShimmer?.root?.visibility = View.GONE
                        }, 1000
                    )
                }
            }
        }
    }
}