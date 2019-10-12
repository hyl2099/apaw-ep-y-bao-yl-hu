package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.TransactionBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TransactionResource.TRANSACTIONS)
public class TransactionResource {
    static final String TRANSACTIONS = "/transactionS";
    private TransactionBusinessController transactionBusinessController;

    @Autowired
    public TransactionResource(TransactionBusinessController transactionBusinessController) {
        this.transactionBusinessController = transactionBusinessController;
    }

    @PostMapping
    public TransactionDto create(@RequestBody TransactionDto transactionDto) {
        transactionDto.validate();
        return this.transactionBusinessController.create(transactionDto);
    }
}
