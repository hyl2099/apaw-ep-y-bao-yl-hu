package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.HouseBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import es.upm.miw.apaw_ep_themes.dtos.HouseDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HouseResource.HOUSES)
public class HouseResource {
    static final String HOUSES = "/houses";
    static final String ID_ID = "/{id}";
    public static final String SEARCH = "/search";
    public static final String PATCH = "/patch";

    private HouseBusinessController houseBusinessController;

    @Autowired
    public HouseResource(HouseBusinessController houseBusinessController) {
        this.houseBusinessController = houseBusinessController;
    }

    @PostMapping
    public HouseDto create(@RequestBody HouseDto houseDto) {
        houseDto.validate();
        return this.houseBusinessController.create(houseDto);
    }

    @GetMapping
    public List<HouseDto> readAll() {
        return this.houseBusinessController.readAll();
    }

    @DeleteMapping(value = ID_ID)
    public void delete(@PathVariable String id) {
        this.houseBusinessController.delete(id);
    }

    @GetMapping(value = SEARCH)
    public List<HouseDto> findHouseByPrice (@RequestParam(required = true) String price){
            return this.houseBusinessController.findHouseByPrice(Double.valueOf(price));
    }
    @PatchMapping(value=PATCH)
    public void update(@RequestBody HouseDtoList dtoList){
        this.houseBusinessController.update(dtoList);
    }

}
