package com.calyrsoft.ucbapp.data.repository

import com.calyrsoft.ucbapp.domain.model.UserModel
import com.calyrsoft.ucbapp.domain.repository.IGithubRepository

class GithubRepository : IGithubRepository {
    override fun findByNick(value: String): Result<UserModel> {
        return Result.success(UserModel("calyr", "https://avatars.githubusercontent.com/u/874321?v=4"))
    }
}