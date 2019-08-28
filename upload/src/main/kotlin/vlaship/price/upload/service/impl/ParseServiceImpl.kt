package vlaship.price.upload.service.impl

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import vlaship.price.common.Product
import vlaship.price.upload.service.ParseService
import java.io.File
import java.io.IOException
import java.math.BigDecimal
import java.nio.charset.Charset
import kotlin.streams.toList

@Component
class ParseServiceImpl : ParseService {

    private val logger = LoggerFactory.getLogger(ParseServiceImpl::class.java)

    override fun parse(fileName: String): List<Product> {
        try {
            return File(fileName).readLines(Charset.forName("Windows-1251")).stream()
                .skip(1)
                .map {
                    val elements = it.replace("\"", "").split(";")
                    Product(
                        null,               // id
                        elements[0],            // brand
                        elements[1],            // category
                        elements[2],            // subCategory
                        elements[3],            // vendorCode
                        elements[4],            // nameProduct
                        BigDecimal(elements[5]) // price
                    )
                }.toList()
        } catch (ex: IOException) {
            logger.error("", ex)
            throw IOException(ex)
        }
    }
}
