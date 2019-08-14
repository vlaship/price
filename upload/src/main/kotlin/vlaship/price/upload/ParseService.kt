package vlaship.price.upload

import vlaship.price.common.Product

interface ParseService {

    fun parse(fileName: String): List<Product>
}