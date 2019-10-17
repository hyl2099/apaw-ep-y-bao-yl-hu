package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.SellerBusinessController;
import es.upm.miw.apaw_ep_themes.documents.Seller;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(SellerResource.SELLERS)
public class SellerResource {

    static final String SELLERS = "/sellers";
    static final String ID_ID = "/{id}";
    public static final String SEARCH = "/search";
    static final String NAME = "/{name}";


    private SellerBusinessController sellerBusinessController;

    @Autowired
    public SellerResource(SellerBusinessController sellerBusinessController) {
        this.sellerBusinessController = sellerBusinessController;
    }

    @PostMapping
    public SellerDto create(@RequestBody SellerDto sellerDto) {
        sellerDto.validate();
        return this.sellerBusinessController.create(sellerDto);
    }

    @GetMapping
    public List<SellerDto> readAll() {
        return this.sellerBusinessController.readAll();
    }

    @GetMapping(value = SEARCH)
    public List<Seller> findSellerByName(@RequestParam("searchSeller") String name) {
        return this.sellerBusinessController.findSellerByName(name);
    }
}

