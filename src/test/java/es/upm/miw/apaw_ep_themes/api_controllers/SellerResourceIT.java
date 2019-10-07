package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class SellerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        SellerDto sellerDto = this.webTestClient
                .post().uri(SellerResource.SELLEERS)
                .body(BodyInserters.fromObject(new SellerDto(null, null)))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class).returnResult().getResponseBody();
        assertNull(sellerDto);
        assertNull(sellerDto.getName());
        assertEquals(null, sellerDto.getCredit());
    }

    @Test
    void testCreateSellerException() {
        SellerDto sellerDto = new SellerDto(null, null);
        this.webTestClient
                .post().uri(SellerResource.SELLEERS)
                .body(BodyInserters.fromObject(sellerDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

}