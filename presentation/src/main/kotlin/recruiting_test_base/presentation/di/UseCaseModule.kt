package recruiting_test_base.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import recruiting_test_base.domain.repository.local.LocalSampleRepository
import recruiting_test_base.domain.repository.remote.SampleRepository
import recruiting_test_base.domain.usecase.GetLocalSampleUseCase
import recruiting_test_base.domain.usecase.GetSampleUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetSampleUseCase(repository: SampleRepository): GetSampleUseCase {
        return GetSampleUseCase(repository)
    }

    @Provides
    fun providesGetLocalSampleUseCase(repository: LocalSampleRepository): GetLocalSampleUseCase {
        return GetLocalSampleUseCase(repository)
    }
}