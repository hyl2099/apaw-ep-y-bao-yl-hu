package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.business_controllers.HouseBusinessController;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(HouseResource.HOUSES)
public class HouseResource {
    static final String HOUSES = "/houses";

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

}
