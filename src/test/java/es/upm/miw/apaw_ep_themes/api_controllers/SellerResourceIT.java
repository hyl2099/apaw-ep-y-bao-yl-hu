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
import java.util.List;

import static org.junit.Assert.assertEquals;
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
    void TestSearch(){
        SellerDto sellerDto = new SellerDto(null,"Yuling",100);
        SellerDto sellerDto2 = new SellerDto(null,"Yuling",130);
        SellerDto sellerDto3 = new SellerDto(null,"Yuling",190);
        String id1 = this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(sellerDto2))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class)
                .returnResult().getResponseBody().getId();
        String id2 = this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(sellerDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class)
                .returnResult().getResponseBody().getId();
        String id3 = this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(sellerDto3))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class)
                .returnResult().getResponseBody().getId();
        List<SellerDto> sellers = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(SellerResource.SELLERS + SellerResource.SEARCH)
                                .queryParam("q","name:Yuling")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SellerDto.class)
                .returnResult().getResponseBody();
        System.out.print(sellers);
        assertFalse(sellers.isEmpty());
    }


    @Test
    void TestSearchException(){
        SellerDto sellerDto = new SellerDto(null,"Melisa",100);
        SellerDto sellerDto2 = new SellerDto(null,"Melisa",130);
        SellerDto sellerDto3 = new SellerDto(null,"Melisa",190);
        String id1 = this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(sellerDto2))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class)
                .returnResult().getResponseBody().getId();
        String id2 = this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(sellerDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class)
                .returnResult().getResponseBody().getId();
        String id3 = this.webTestClient
                .post().uri(SellerResource.SELLERS)
                .body(BodyInserters.fromObject(sellerDto3))
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class)
                .returnResult().getResponseBody().getId();
        List<SellerDto> sellers = this.webTestClient
                .get().uri(uriBuilder ->
                        uriBuilder.path(SellerResource.SELLERS + SellerResource.SEARCH)
                                .queryParam("q","name:Yulin")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(SellerDto.class)
                .returnResult().getResponseBody();
        assertTrue(sellers.isEmpty());
    }

    @Test
    void testSellerUpdate() {
        String id = this.createSeller("001","Yuling",100).getId();
        SellerDto newSeller = new SellerDto();
        newSeller.setName("Melisa");
        this.webTestClient
                .put().uri(SellerResource.SELLERS + SellerResource.ID_ID +SellerResource.NAME, id)
                .body(BodyInserters.fromObject(newSeller))
                .exchange()
                .expectStatus().isOk();
        newSeller = this.webTestClient
                .get().uri(SellerResource.SELLERS + SellerResource.ID_ID+SellerResource.NAME, id)
                .exchange()
                .expectStatus().isOk()
                .expectBody(SellerDto.class)
                .returnResult().getResponseBody();
        System.out.print(newSeller);
        assertEquals(id, newSeller.getId());
        assertEquals("Melisa", newSeller.getName());
    }

    @Test
    void testPutNameNotFoundException() {
        String id = this.createSeller("001","Yuling",100).getId();
        this.webTestClient
                .put().uri(SellerResource.SELLERS + SellerResource.ID_ID + SellerResource.NAME, id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}