package com.calyrsoft.ucbapp.di


import com.calyrsoft.ucbapp.data.repository.GithubRepository
import com.calyrsoft.ucbapp.domain.repository.IGithubRepository
import com.calyrsoft.ucbapp.domain.usecase.FindByNickNameUseCase
import com.calyrsoft.ucbapp.presentation.GithubViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module(){
    single<IGithubRepository>{ GithubRepository() }
    factory { FindByNickNameUseCase(get()) }
    viewModel { GithubViewModel(get()) }
}