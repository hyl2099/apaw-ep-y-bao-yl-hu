package es.upm.miw.apaw_ep_themes.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseDtoTest {
    private HouseDto houseDto = new HouseDto();

    @Test
    void setPrice() {
        houseDto.setPrice(100.0);
        assertEquals(100.0, houseDto.getPrice());
    }

    @Test
    void setArea() {
        houseDto.setArea(100.0);
        assertEquals(100.0, houseDto.getArea());
    }
}