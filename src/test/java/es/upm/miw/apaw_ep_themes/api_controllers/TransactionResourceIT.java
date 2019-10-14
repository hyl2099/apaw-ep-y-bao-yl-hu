package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.BuyerDto;
import es.upm.miw.apaw_ep_themes.dtos.TransactionDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
class TransactionResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        TransactionDto transactionDto = createTransaction("1");
        assertEquals("1", transactionDto.getHouse());
    }

    TransactionDto createTransaction(String house) {
        TransactionDto transactionDto =
                new TransactionDto(LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52), house);
        return this.webTestClient
                .post().uri(TransactionResource.TRANSACTIONS)
                .body(BodyInserters.fromObject(transactionDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(TransactionDto.class)
                .returnResult().getResponseBody();
    }

    @Test
    void testHouseException() {
        TransactionDto transactionDto = new TransactionDto(null, "1");
        this.webTestClient
                .post().uri(TransactionResource.TRANSACTIONS)
                .body(BodyInserters.fromObject(transactionDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPutHouse() {
        String id = createTransaction("2").getId();
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setHouse("newHouse");
        this.webTestClient
                .put().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.HOUSE, id)
                .body(BodyInserters.fromObject(transactionDto))
                .exchange()
                .expectStatus().isOk();
        transactionDto = this.webTestClient
                .get().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.HOUSE, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(TransactionDto.class)
                .returnResult().getResponseBody();
        assertEquals(id, transactionDto.getId());
        assertEquals("newHouse", transactionDto.getHouse());
    }

    @Test
    void testPutNotFoundException() {
        String id = createTransaction("3").getId();
        this.webTestClient
                .put().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.HOUSE, id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPutHouseBadRequestException() {
        this.webTestClient
                .put().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.HOUSE, "no")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testGetTransactionHouse() {
        String id = createTransaction("4").getId();
        TransactionDto transactionDto = this.webTestClient
                .get().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.HOUSE, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(TransactionDto.class)
                .returnResult().getResponseBody();
        assertEquals(id, transactionDto.getId());
        assertEquals("4", transactionDto.getHouse());
    }

    @Test
    void testGetTransactionHouseException() {
        this.webTestClient
                .get().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.HOUSE, "no")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testCreateBuyers() {
        String id = createTransaction("5").getId();
        this.webTestClient
                .post().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.BUYERS, id)
                .body(BodyInserters.fromObject(new BuyerDto("2", "123", "123")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(TransactionDto.class)
                .returnResult().getResponseBody();
    }


    @Test
    void testCreateBuyersTransactionIdException() {
        this.webTestClient
                .post().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.BUYERS, "n0")
                .body(BodyInserters.fromObject(new BuyerDto("2", "123", "123")))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void testCreateBuyersException() {
        this.webTestClient
                .post().uri(TransactionResource.TRANSACTIONS + TransactionResource.ID_ID + TransactionResource.BUYERS, "n0")
                .body(BodyInserters.fromObject(new BuyerDto()))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
