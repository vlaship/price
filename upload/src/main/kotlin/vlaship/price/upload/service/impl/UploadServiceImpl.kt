package vlaship.price.upload.service.impl

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import vlaship.price.upload.service.ParseService
import vlaship.price.upload.repository.ProductRepository
import vlaship.price.upload.service.UploadService
import java.io.IOException

@Component
class UploadServiceImpl(
    private val repository: ProductRepository,
    private val parseService: ParseService
) : UploadService {

    private val logger = LoggerFactory.getLogger(UploadServiceImpl::class.java)


    @Value("\${path.to.file}")
    lateinit var pathToFile: String

    override fun clear() {
        repository.deleteAll()
    }

    override fun upload() {
        try {
            val list = parseService.parse(pathToFile)
            repository.saveAll(list)
        } catch (ex: IOException) {
            logger.error("", ex)
        }
    }

}