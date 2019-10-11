package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
public class HouseResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        HouseDto houseDto = new HouseDto(100000.0, LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52),116.0,false);
        this.webTestClient
                .post().uri(HouseResource.HOUSES)
                .body(BodyInserters.fromObject(houseDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(HouseDto.class)
                .returnResult().getResponseBody();
        assertNotNull(houseDto);
        assertEquals(100000.0, houseDto.getPrice());
        assertEquals(116.0, houseDto.getArea());
        assertEquals(LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52),houseDto.getDealDate());
        assertFalse(houseDto.getIsNew());
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



}