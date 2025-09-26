package com.calyrsoft.ucbapp.features.dollar.data.repository

import com.calyrsoft.ucbapp.features.dollar.datasource.RealTimeRemoteDataSource
import com.calyrsoft.ucbapp.features.dollar.domain.model.DollarModel
import com.calyrsoft.ucbapp.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DollarRepository(val realTimeRemoteDataSource: RealTimeRemoteDataSource): IDollarRepository {

    override suspend fun getDollar(): Flow<DollarModel> {
//        return flow {
//            emit(DollarModel("123", "456"))
//        }
        return realTimeRemoteDataSource.getDollarUpdates()

    }
}

