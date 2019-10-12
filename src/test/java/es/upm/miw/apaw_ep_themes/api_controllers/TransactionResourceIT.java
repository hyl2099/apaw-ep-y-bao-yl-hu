package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import es.upm.miw.apaw_ep_themes.dtos.TransactionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
@ApiTestConfig
class TransactionResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        TransactionDto transactionDto = new TransactionDto(LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52),"001");
        this.webTestClient
                .post().uri(TransactionResource.TRANSACTIONS)
                .body(BodyInserters.fromObject(transactionDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(HouseDto.class)
                .returnResult().getResponseBody();
        assertNotNull(transactionDto);
        assertEquals(LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52), transactionDto.getDate());
        assertEquals("001", transactionDto.getHouse());
    }

    @Test
    void testHouseException() {
        TransactionDto transactionDto = new TransactionDto(null,"001");
        this.webTestClient
                .post().uri(TransactionResource.TRANSACTIONS)
                .body(BodyInserters.fromObject(transactionDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}