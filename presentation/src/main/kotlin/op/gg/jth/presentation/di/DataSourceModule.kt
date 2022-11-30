package op.gg.jth.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import op.gg.jth.data.datasource.local.GamesLocalSource
import op.gg.jth.data.datasource.local.GamesLocalSourceImpl
import op.gg.jth.data.datasource.remote.GamesRemoteSource
import op.gg.jth.data.datasource.remote.GamesRemoteSourceImpl
import op.gg.jth.data.datasource.remote.SummonerRemoteSource
import op.gg.jth.data.datasource.remote.SummonerRemoteSourceImpl
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

    @Singleton
    @Binds
    abstract fun bindGamesLocalSource(source: GamesLocalSourceImpl): GamesLocalSource
}