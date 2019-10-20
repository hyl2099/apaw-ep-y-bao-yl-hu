package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import es.upm.miw.apaw_ep_themes.dtos.HouseDtoList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class HouseResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        HouseDto houseDto = testCreateHouse(100000.0);
        assertEquals(100000.0, houseDto.getPrice());
    }

    HouseDto testCreateHouse(double price) {
        HouseDto houseDto = new HouseDto(price, LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52),116.0,false);
        return this.webTestClient
                .post().uri(HouseResource.HOUSES)
                .body(BodyInserters.fromObject(houseDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(HouseDto.class)
                .returnResult().getResponseBody();
    }

    @Test
    void testHouseException() {
        HouseDto houseDto = new HouseDto(100000.0, null,116.0,false);
        this.webTestClient
                .post().uri(HouseResource.HOUSES)
                .body(BodyInserters.fromObject(houseDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testDeleteHouse() {
        String id = testCreateHouse(100000.0).getId();
        HouseDto houseDto= new HouseDto();
        this.webTestClient
                .post().uri(HouseResource.HOUSES)
                .body(BodyInserters.fromObject(houseDto))
                .exchange();
        this.webTestClient
                .delete().uri(HouseResource.HOUSES +  HouseResource.ID_ID , id)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void deleteException() {
        String id = null;
        this.webTestClient
                .delete().uri(HouseResource.HOUSES +  HouseResource.ID_ID , id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPatchHouse() {
        HouseDto houseDto= new HouseDto(800.00, LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52),100.00,true);
        houseDto = this.webTestClient
                .post().uri(HouseResource.HOUSES)
                .body(BodyInserters.fromObject(houseDto))
                .exchange().expectStatus().isOk()
                .expectBody(HouseDto.class)
                .returnResult().getResponseBody();
        System.out.println("first:"+houseDto);
        houseDto.setPrice(80.0);
        List<HouseDto> list = new ArrayList<>();
        list.add(houseDto);
        HouseDtoList houseDtoList = new HouseDtoList();
        houseDtoList.setHouseList(list);
        this.webTestClient
                .patch().uri(HouseResource.HOUSES+HouseResource.PATCH)
                .body(BodyInserters.fromObject(houseDtoList))
                .exchange();
       List<HouseDto> houseDto_List = this.webTestClient
                .get().uri(HouseResource.HOUSES)
                .exchange().expectStatus().isOk()
                .expectBodyList(HouseDto.class)
                .returnResult().getResponseBody();
        System.out.println("second:"+houseDto_List.toString());
    }
}