package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.HouseDao;
import es.upm.miw.apaw_ep_themes.documents.House;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HouseBusinessController {
    private HouseDao houseDao;

    @Autowired
    public HouseBusinessController(HouseDao houseDao) {
        this.houseDao = houseDao;
    }

    public HouseDto create(HouseDto houseDto) {
        House house = new House(house.getPrice(), house.getDealDate(),house.getArea(),house.getIsNew());
        this.houseDao.save(house);
        return new HouseDto(house);
    }

    public List<HouseDto> readAll() {
        List<House> houses = this.houseDao.findAll();
        return houses.stream().map(HouseDto::new).collect(Collectors.toList());
    }
}
