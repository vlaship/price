package vlaship.price.upload

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import vlaship.price.upload.service.impl.UploadServiceImpl

@SpringBootApplication
class RunUpload

fun main() {
    val service = runApplication<RunUpload>().getBean(UploadServiceImpl::class.java)
    service.clear()
    service.upload()
}