package com.calyrsoft.ucbapp.features.github.domain.repository

import com.calyrsoft.ucbapp.features.github.domain.model.UserModel

interface IGithubRepository {
    fun findByNick(value: String): Result<UserModel>
}