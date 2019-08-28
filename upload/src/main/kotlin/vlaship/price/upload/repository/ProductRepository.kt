package vlaship.price.upload.repository

import org.springframework.data.mongodb.repository.MongoRepository
import vlaship.price.common.Product

interface ProductRepository : MongoRepository<Product, Long> {

}