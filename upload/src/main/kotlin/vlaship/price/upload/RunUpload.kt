package vlaship.price.upload

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RunUpload

fun main() {
    val service = runApplication<RunUpload>().getBean(UploadServiceImpl::class.java)
    service.clear()
    service.upload()
}