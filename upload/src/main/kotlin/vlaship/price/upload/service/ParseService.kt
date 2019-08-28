package vlaship.price.upload.service

import vlaship.price.common.Product

interface ParseService {

    fun parse(fileName: String): List<Product>
}