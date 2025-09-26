package com.calyrsoft.ucbapp.features.dollar.domain.repository

import com.calyrsoft.ucbapp.features.dollar.domain.model.DollarModel
import kotlinx.coroutines.flow.Flow

interface IDollarRepository {
    suspend fun getDollar(): Flow<DollarModel>
}
