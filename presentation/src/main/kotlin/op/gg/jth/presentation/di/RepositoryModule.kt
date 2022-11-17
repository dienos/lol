package op.gg.jth.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import op.gg.jth.data.repository.GamesRepositoryImpl
import op.gg.jth.data.repository.SummonerRepositoryImpl
import op.gg.jth.domain.repository.remote.GamesRepository
import op.gg.jth.domain.repository.remote.SummonerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSummonerRepositoryImpl(repository: SummonerRepositoryImpl): SummonerRepository

    @Singleton
    @Binds
    abstract fun bindGamesRepository(repository: GamesRepositoryImpl): GamesRepository
}