package com.calyrsoft.ucbapp.features.dollar.data.repository

import com.calyrsoft.ucbapp.features.dollar.domain.model.DollarModel
import com.calyrsoft.ucbapp.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DollarRepository: IDollarRepository {

    override suspend fun getDollar(): Flow<DollarModel> {
        return flow {
            emit(DollarModel("6.96", "12.6"))
        }
    }
}
