package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.SellerBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(SellerResource.SELLERS)
public class SellerResource {

    static final String SELLERS = "/sellers";
    static final String ID_ID = "/{id}";
    public static final String SEARCH = "/search";
    static final String NAME = "/name";


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
    public List<SellerDto> findByName(@RequestParam String q) {
        if (!"name".equals(q.split(":")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'name:'");
        }
        return this.sellerBusinessController.findByName(String.valueOf(q.split(":")[1]));
    }

    @GetMapping(value = ID_ID + NAME)
    public SellerDto readName(@PathVariable String id) {
        return this.sellerBusinessController.readName(id);
    }

    @PutMapping(value = ID_ID + NAME)
    public void updateName(@PathVariable String id, @RequestBody SellerDto sellerDto) {
        this.sellerBusinessController.updateName(id, sellerDto.getName());
    }
}

