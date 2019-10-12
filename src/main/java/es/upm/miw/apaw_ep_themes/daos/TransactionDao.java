package es.upm.miw.apaw_ep_themes.daos;


import es.upm.miw.apaw_ep_themes.documents.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionDao extends MongoRepository<Transaction, String> {
}
