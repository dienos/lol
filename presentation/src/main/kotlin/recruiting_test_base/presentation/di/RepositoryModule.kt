package recruiting_test_base.presentation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import recruiting_test_base.data.repository.LocalSampleRepositoryImpl
import recruiting_test_base.data.repository.SampleRepositoryImpl
import recruiting_test_base.domain.repository.local.LocalSampleRepository
import recruiting_test_base.domain.repository.remote.SampleRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSampleRepository(repository: SampleRepositoryImpl): SampleRepository

    @Singleton
    @Binds
    abstract fun bindLocalSampleRepository(repository: LocalSampleRepositoryImpl): LocalSampleRepository
}