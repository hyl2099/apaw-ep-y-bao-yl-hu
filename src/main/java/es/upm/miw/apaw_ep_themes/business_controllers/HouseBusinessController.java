package es.upm.miw.apaw_ep_themes.business_controllers;

import es.upm.miw.apaw_ep_themes.daos.HouseDao;
import es.upm.miw.apaw_ep_themes.documents.House;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import es.upm.miw.apaw_ep_themes.dtos.HouseDtoList;
import es.upm.miw.apaw_ep_themes.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        House house = new House(price, dealDate, area, isNew);
        this.houseDao.save(house);
        return new HouseDto(house);
    }

    public List<HouseDto> readAll() {
        List<House> houses = this.houseDao.findAll();
        return houses.stream().map(HouseDto::new).collect(Collectors.toList());
    }

    private House findHouseByIdAssured(String id) {
        return this.houseDao.findById(id).orElseThrow(() -> new NotFoundException("Transaction id: " + id));
    }

    public void delete(String id) {
        House house = findHouseByIdAssured(id);
        this.houseDao.delete(house);
    }

    public List<HouseDto> findHouseByPrice(double price) {
        List<House> houseList = this.houseDao.findByPriceGreaterThan(price);
        HouseDto dto = null;
        List<HouseDto> list = new ArrayList<>();

        for (House house : houseList) {
            dto = new HouseDto(house);
            list.add(dto);
        }
        return list;
    }

    public void update(HouseDtoList dtoList) {
        for (HouseDto houseDto : dtoList.getHouseList()) {
            House house = new House();
            house.setId(houseDto.getId());
            house = this.houseDao.findById(houseDto.getId()).orElse(null);
            if (house != null) {
                house.setPrice(houseDto.getPrice());
            }
            houseDao.save(house);
        }
    }
}
