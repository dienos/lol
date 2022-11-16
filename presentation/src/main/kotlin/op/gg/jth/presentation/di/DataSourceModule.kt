package op.gg.jth.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import op.gg.jth.data.datasource.GamesRemoteSource
import op.gg.jth.data.datasource.GamesRemoteSourceImpl
import op.gg.jth.data.datasource.SummonerRemoteSource
import op.gg.jth.data.datasource.SummonerRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindSummonerRemoteSource(source: SummonerRemoteSourceImpl): SummonerRemoteSource

    @Singleton
    @Binds
    abstract fun bindGamesRemoteSource(source: GamesRemoteSourceImpl): GamesRemoteSource
}