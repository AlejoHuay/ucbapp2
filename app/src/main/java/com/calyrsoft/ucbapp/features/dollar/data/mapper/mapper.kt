package com.calyrsoft.ucbapp.features.dollar.data.mapper

import com.calyrsoft.ucbapp.features.dollar.data.database.entity.DollarEntity
import com.calyrsoft.ucbapp.features.dollar.domain.model.DollarModel

fun DollarEntity.toModel() : DollarModel {
    return DollarModel(
        dollarOfficial = dollarOfficial,
        dollarParallel = dollarParallel,
        dollarCompra = dollarCompra,
        dollarVenta= dollarVenta
    )
}

fun DollarModel.toEntity() : DollarEntity {
    return DollarEntity(
        dollarOfficial = dollarOfficial,
        dollarParallel = dollarParallel,
        dollarCompra = dollarCompra,
        dollarVenta= dollarVenta
    )
}
