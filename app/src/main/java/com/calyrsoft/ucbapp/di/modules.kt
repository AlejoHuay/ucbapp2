package com.calyrsoft.ucbapp.di


import com.calyrsoft.ucbapp.features.dollar.data.database.AppRoomDatabase
import com.calyrsoft.ucbapp.features.dollar.data.datasource.DollarLocalDataSource
import com.calyrsoft.ucbapp.features.dollar.data.repository.DollarRepository
import com.calyrsoft.ucbapp.features.dollar.data.datasource.RealTimeRemoteDataSource
import com.calyrsoft.ucbapp.features.dollar.domain.repository.IDollarRepository
import com.calyrsoft.ucbapp.features.dollar.domain.usecase.FetchDollarUseCase
import com.calyrsoft.ucbapp.features.dollar.presentation.DollarViewModel
import com.calyrsoft.ucbapp.features.github.data.api.GithubService
import com.calyrsoft.ucbapp.features.github.data.datasource.GithubRemoteDataSource
import com.calyrsoft.ucbapp.features.github.data.repository.GithubRepository
import com.calyrsoft.ucbapp.features.github.domain.repository.IGithubRepository
import com.calyrsoft.ucbapp.features.github.domain.usecase.FindByNickNameUseCase
import com.calyrsoft.ucbapp.features.github.presentation.GithubViewModel
import com.calyrsoft.ucbapp.features.profile.application.ProfileViewModel
import com.calyrsoft.ucbapp.features.profile.data.repository.ProfileRepository
import com.calyrsoft.ucbapp.features.profile.domain.repository.IProfileRepository
import com.calyrsoft.ucbapp.features.profile.domain.usecase.GetProfileUseCase
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module{ // definimos como se van a llamar a las dependencias que se van a nescesitar
    // OkHttpClient
    single {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // GithubService
    single<GithubService> {
        get<Retrofit>().create(GithubService::class.java)
    }

    single { GithubRemoteDataSource(get()) }
    single<IGithubRepository>{ GithubRepository(get()) }

    factory { FindByNickNameUseCase(get()) }
    viewModel { GithubViewModel(get (),get ()) }

    single<IProfileRepository> { ProfileRepository() }
    factory { GetProfileUseCase(get()) }
    viewModel { ProfileViewModel(get()) }

    single { AppRoomDatabase.getDatabase(get()) }
    single { get<AppRoomDatabase>().dollarDao() }
    single { RealTimeRemoteDataSource() }
    single { DollarLocalDataSource(get()) }
    single<IDollarRepository> { DollarRepository(get(), get()) }
    factory { FetchDollarUseCase(get()) }
    viewModel{ DollarViewModel(get()) }

}