package vlaship.price.upload

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class UploadServiceImpl(
    private val repository: ProductRepository,
    private val parseService: ParseService
) : UploadService {

    @Value("\${path.to.file}")
    lateinit var pathToFile: String

    override fun clear() {
        repository.deleteAll()
    }

    override fun upload() {
        val list = parseService.parse(pathToFile)
        repository.saveAll(list)
    }

}