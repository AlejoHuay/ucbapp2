package com.calyrsoft.ucbapp.di


import com.calyrsoft.ucbapp.features.github.data.repository.GithubRepository
import com.calyrsoft.ucbapp.features.github.domain.repository.IGithubRepository
import com.calyrsoft.ucbapp.features.github.domain.usecase.FindByNickNameUseCase
import com.calyrsoft.ucbapp.features.github.presentation.GithubViewModel
import com.calyrsoft.ucbapp.features.profile.application.ProfileViewModel
import com.calyrsoft.ucbapp.features.profile.data.repository.ProfileRepository
import com.calyrsoft.ucbapp.features.profile.domain.repository.IProfileRepository
import com.calyrsoft.ucbapp.features.profile.domain.usecase.GetProfileUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{ // definimos como se van a llamar a las dependencias que se van a nescesitar
    single<IGithubRepository>{ GithubRepository() }
    factory { FindByNickNameUseCase(get()) }
    viewModel { GithubViewModel(get()) }

    viewModel { ProfileViewModel(get()) }
    factory { GetProfileUseCase(get()) }
    single<IProfileRepository> { ProfileRepository() }
}