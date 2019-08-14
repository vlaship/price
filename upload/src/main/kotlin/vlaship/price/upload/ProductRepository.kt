package vlaship.price.upload

import org.springframework.data.mongodb.repository.MongoRepository
import vlaship.price.common.Product

interface ProductRepository : MongoRepository<Product, Long> {

}