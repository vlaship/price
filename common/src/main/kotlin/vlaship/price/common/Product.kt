package vlaship.price.common

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document(collection = "prices")
data class Product(
    @Id
    val id: String?,
    val brand: String,
    val category: String,
    val subCategory: String,
    @Indexed(unique = true)
    val vendorCode: String,
    val nameProduct: String,
    val price: BigDecimal
)