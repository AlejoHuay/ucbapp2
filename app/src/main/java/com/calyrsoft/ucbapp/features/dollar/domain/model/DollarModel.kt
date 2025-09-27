package com.calyrsoft.ucbapp.features.dollar.domain.model

import kotlin.String

/*data class DollarModel(val dollarOfficial: String, val dollarParelelo: String) {
}*/
data class DollarModel(
    var dollarOfficial: String? = null,
    var dollarParallel: String? = null,
    var dollarCompra: String? = null,
    var dollarVenta: String? = null

)
