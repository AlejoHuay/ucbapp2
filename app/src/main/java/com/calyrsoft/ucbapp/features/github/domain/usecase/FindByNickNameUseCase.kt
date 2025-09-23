package com.calyrsoft.ucbapp.features.github.domain.usecase

import com.calyrsoft.ucbapp.features.github.domain.model.UserModel
import com.calyrsoft.ucbapp.features.github.domain.repository.IGithubRepository
import kotlinx.coroutines.delay

class FindByNickNameUseCase(
    val repository: IGithubRepository
) {
    suspend fun invoke(nickname: String) : Result<UserModel>  {
        delay(2000)
        return repository.findByNick(nickname)
    }
}
