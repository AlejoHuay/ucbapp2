package com.calyrsoft.ucbapp.domain.repository

import com.calyrsoft.ucbapp.domain.model.UserModel

interface IGithubRepository {
    fun findByNick(value: String): Result<UserModel>
}