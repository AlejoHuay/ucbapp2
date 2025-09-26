package com.calyrsoft.ucbapp.features.dollar.domain.usecase

import com.calyrsoft.ucbapp.features.dollar.domain.model.DollarModel
import com.calyrsoft.ucbapp.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow

class FetchDollarUseCase(
    val repository: IDollarRepository
) {

    suspend fun invoke(): Flow<DollarModel> {
        return repository.getDollar()
    }
}
