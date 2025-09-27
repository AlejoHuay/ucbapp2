package com.calyrsoft.ucbapp.features.dollar.data.repository

import com.calyrsoft.ucbapp.features.dollar.data.datasource.DollarLocalDataSource
import com.calyrsoft.ucbapp.features.dollar.data.datasource.RealTimeRemoteDataSource
import com.calyrsoft.ucbapp.features.dollar.domain.model.DollarModel
import com.calyrsoft.ucbapp.features.dollar.domain.repository.IDollarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class DollarRepository(
    val realTimeRemoteDataSource: RealTimeRemoteDataSource,
    val localDataSource: DollarLocalDataSource
): IDollarRepository {

    override suspend fun getDollar(): Flow<DollarModel> {
//        return flow {
//            emit(DollarModel("123", "456"))
//        }
        return realTimeRemoteDataSource.getDollarUpdates()
            .onEach {
                localDataSource.insert(it)
            }


    }
}

