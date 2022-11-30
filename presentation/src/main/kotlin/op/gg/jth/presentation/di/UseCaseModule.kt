package op.gg.jth.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import op.gg.jth.domain.repository.local.LocalGamesRepository
import op.gg.jth.domain.repository.remote.GamesRepository
import op.gg.jth.domain.repository.remote.SummonerRepository
import op.gg.jth.domain.usecase.GetGamesUseCase
import op.gg.jth.domain.usecase.GetMostWinningRateChampionsUseCase
import op.gg.jth.domain.usecase.GetRecentTwentyGamesUseCase
import op.gg.jth.domain.usecase.GetSummonerUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetSummonerUseCase(repository: SummonerRepository): GetSummonerUseCase {
        return GetSummonerUseCase(repository)
    }

    @Provides
    fun providesGetGamesUseCase(repository: GamesRepository): GetGamesUseCase {
        return GetGamesUseCase(repository)
    }

    @Provides
    fun providesGetRecentTwentyGamesUseCase(repository: LocalGamesRepository): GetRecentTwentyGamesUseCase {
        return GetRecentTwentyGamesUseCase(repository)
    }

    @Provides
    fun providesGetMostWinningRateChampionsUseCase(repository: LocalGamesRepository): GetMostWinningRateChampionsUseCase {
        return GetMostWinningRateChampionsUseCase(repository)
    }
}