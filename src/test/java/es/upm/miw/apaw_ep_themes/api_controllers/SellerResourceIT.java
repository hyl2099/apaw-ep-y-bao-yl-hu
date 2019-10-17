package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.daos.SellerDao;
import es.upm.miw.apaw_ep_themes.documents.Seller;
import es.upm.miw.apaw_ep_themes.dtos.SellerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ApiTestConfig
class SellerResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private SellerDao sellerDao;


    SellerDto createSeller(String id, String name, int credit) {
        SellerDto sellerDto = new SellerDto(id,name,credit);
        return this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(sellerDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class)
                .returnResult().getResponseBody();
    }

    @Test
    void testCreate() {
        SellerDto dto = new SellerDto(null,"123",1);
        SellerDto sellerDto = this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(dto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class).returnResult().getResponseBody();
        assertNotNull(sellerDto.getId());
        assertNotNull(sellerDto.getName());
        assertNotNull(sellerDto.getCredit());

    }

    @Test
    public void insert01(){
        SellerDto sellerDto = new SellerDto("123", 1);
        Seller seller = new Seller(sellerDto.getName(), sellerDto.getCredit());
        sellerDao.save(seller);
        assertNotNull(sellerDao.save(seller));
        System.out.println("save success!");

    }

    @Test
    void testCreateSellerException() {
        SellerDto sellerDto = new SellerDto(null, null);
        this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(sellerDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
    @Test
    void ReadAll() {
        SellerDto suggestionDto = new  SellerDto("baoying", 2);
        this.webTestClient
                .post().uri( SellerResource.SELLERS)
                .body(BodyInserters.fromObject(suggestionDto))
                .exchange()
                .expectStatus().isOk();
        List< SellerDto> list =
                this.webTestClient
                        .get().uri( SellerResource.SELLERS)
                        .exchange()
                        .expectStatus().isOk()
                        .expectBodyList( SellerDto.class)
                        .returnResult().getResponseBody();
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).getId());
        assertNotNull(list.get(0).getName());
        assertNotNull(list.get(0).getCredit());
    }

    @Test
    void testFindSellerByName(){
        this.createSeller(null,"good", 1);
        this.createSeller(null,"good", 2);
        this.createSeller(null,"good", 3);

//        List<SellerDto> sellers = this.webTestClient
//                .get().uri(uriBuilder ->
//                        uriBuilder.path(SellerResource.SELLERS + SellerResource.SEARCH)
//                                .queryParam("q", "name:good")
//                                .build())
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(SellerDto.class)
//                .returnResult().getResponseBody();
//        assertFalse(sellers.isEmpty());
    }
}