package es.upm.miw.apaw_ep_themes.daos;


import es.upm.miw.apaw_ep_themes.documents.House;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HouseDao extends MongoRepository<House, String>{

    List<House> findByPriceGreaterThan(Double price) ;

}
