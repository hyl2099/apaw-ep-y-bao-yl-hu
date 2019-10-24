package es.upm.miw.apaw_ep_themes.daos;

import es.upm.miw.apaw_ep_themes.documents.Buyer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuyerDao extends MongoRepository<Buyer, String> {
}
