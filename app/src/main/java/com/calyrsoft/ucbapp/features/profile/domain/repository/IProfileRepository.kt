package com.calyrsoft.ucbapp.features.profile.domain.repository

import com.calyrsoft.ucbapp.features.profile.domain.model.ProfileModel

interface IProfileRepository {
    fun fetchData(): Result<ProfileModel>
}