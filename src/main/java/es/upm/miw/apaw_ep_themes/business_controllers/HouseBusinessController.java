package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.HouseDao;
import es.upm.miw.apaw_ep_themes.documents.House;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
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
        double price = houseDto.getPrice();
        LocalDateTime dealDate = houseDto.getDealDate();
        double area = houseDto.getArea();
        Boolean isNew = houseDto.getIsNew();
        House house = new House(price,dealDate,area,isNew);
        this.houseDao.save(house);
        return new HouseDto(house);
    }

    public List<HouseDto> readAll() {
        List<House> houses = this.houseDao.findAll();
        return houses.stream().map(HouseDto::new).collect(Collectors.toList());
    }
}
