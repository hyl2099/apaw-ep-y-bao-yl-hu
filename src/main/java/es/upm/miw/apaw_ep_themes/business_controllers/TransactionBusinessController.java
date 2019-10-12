package es.upm.miw.apaw_ep_themes.business_controllers;


import es.upm.miw.apaw_ep_themes.daos.TransactionDao;
import es.upm.miw.apaw_ep_themes.documents.Transaction;
import es.upm.miw.apaw_ep_themes.dtos.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class TransactionBusinessController {
    private TransactionDao transactionDao;

    @Autowired
    public TransactionBusinessController(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public TransactionDto create(TransactionDto transactionDto) {
        LocalDateTime date = transactionDto.getDate();
        String house = transactionDto.getHouse();
        Transaction transaction = new Transaction(date,house);
        this.transactionDao.save(transaction);
        return new TransactionDto(transaction);
    }
}
