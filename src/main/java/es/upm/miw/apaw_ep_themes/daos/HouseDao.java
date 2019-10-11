package es.upm.miw.apaw_ep_themes.daos;


import es.upm.miw.apaw_ep_themes.documents.House;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HouseDao extends MongoRepository<House, String>{
}
