package com.calyrsoft.ucbapp.features.github.domain.usecase

import com.calyrsoft.ucbapp.features.github.domain.model.UserModel
import com.calyrsoft.ucbapp.features.github.domain.repository.IGithubRepository

class FindByNickNameUseCase(
    val repository: IGithubRepository
) {
    fun invoke(nickname: String) : Result<UserModel>{
        return repository.findByNick(nickname)
    }
}