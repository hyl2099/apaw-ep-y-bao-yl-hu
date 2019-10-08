package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.SellerBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SellerResource.SELLERS)
public class SellerResource {

    static final String SELLERS = "/sellers";

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

}
