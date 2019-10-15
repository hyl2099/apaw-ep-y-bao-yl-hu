package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.TransactionBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.BuyerDto;
import es.upm.miw.apaw_ep_themes.dtos.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TransactionResource.TRANSACTIONS)
public class TransactionResource {
    static final String TRANSACTIONS = "/transactions";
    static final String ID_ID = "/{id}";
    static final String HOUSE = "/house";
    static final String BUYERS= "/buyers";
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
    @GetMapping(value = ID_ID + HOUSE)
    public TransactionDto readhouse(@PathVariable String id) {
        return this.transactionBusinessController.readHouse(id);
    }

    @PutMapping(value = ID_ID + HOUSE)
    public void updateHouse(@PathVariable String id, @RequestBody TransactionDto transactionDto) {
        transactionDto.validateHouse();
        this.transactionBusinessController.updateHouse(id, transactionDto.getHouse());
    }

    @PostMapping(value = ID_ID + BUYERS)
    public void createBuyer(@PathVariable String id, @RequestBody BuyerDto buyerDto) {
        buyerDto.validate();
        this.transactionBusinessController.createBuyer(id, buyerDto.getName(),buyerDto.getAddress(),buyerDto.getBankAccount());
    }
}
