package com.calyrsoft.ucbapp.domain.usecase

import com.calyrsoft.ucbapp.domain.model.UserModel
import com.calyrsoft.ucbapp.domain.repository.IGithubRepository

class FindByNickNameUseCase(
    val repository: IGithubRepository
) {
    fun invoke(nickname: String) : Result<UserModel>{
        return repository.findByNick(nickname)
    }
}