package recruiting_test_base.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import recruiting_test_base.data.datasource.SampleLocalSource
import recruiting_test_base.data.datasource.SampleLocalSourceImpl
import recruiting_test_base.data.datasource.SampleRemoteSource
import recruiting_test_base.data.datasource.SampleRemoteSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindSimpleRemoteSource(source: SampleRemoteSourceImpl): SampleRemoteSource

    @Singleton
    @Binds
    abstract fun bindSimpleLocalSource(source: SampleLocalSourceImpl): SampleLocalSource
}