package apaw.daos;

import apaw.documents.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerDao extends MongoRepository<Seller, String> {
}