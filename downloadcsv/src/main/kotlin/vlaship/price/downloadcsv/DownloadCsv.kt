package vlaship.price.downloadcsv

import java.io.*

import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DownloadCsv {

    @Value("\${login}")
    private lateinit var login: String
    @Value("\${pass}")
    private lateinit var password: String
    @Value("\${form.login}")
    private lateinit var formLogin: String
    @Value("\${form.password}")
    private lateinit var formPassword: String
    @Value("\${url.login}")
    private lateinit var urlLogin: String
    @Value("\${url.file}")
    private lateinit var urlFile: String
    @Value("\${local.file}")
    private lateinit var pathFile: String

    private val logger = LoggerFactory.getLogger(DownloadCsv::class.java)

    fun download() {
        val httpClient = HttpClients.createDefault()

        logger.info("logining")
        httpClient.execute(HttpPost("$urlLogin?$formLogin=$login&$formPassword=$password"))

        logger.info("downloading")
        val httpGet = HttpGet(urlFile)
        val entity = httpClient.execute(httpGet).entity
        if (entity != null) {
            logger.info("saving")
            BufferedInputStream(entity.content)
                .use { bis ->
                    BufferedOutputStream(FileOutputStream(File(pathFile)))
                        .use { bos ->
                            while (true) {
                                val inByte = bis.read()
                                if (inByte == -1) break
                                bos.write(inByte)
                            }
                        }
                }
            logger.info("finished")
        } else {
            logger.warn("downloaded file is empty")
        }
    }
}

fun main(args: Array<String>) {
    val context = runApplication<DownloadCsv>(*args)
    context.getBean(DownloadCsv::class.java).download()
}


