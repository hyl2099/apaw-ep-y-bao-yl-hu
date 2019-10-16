package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.HouseDto;
import es.upm.miw.apaw_ep_themes.dtos.MaterialDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
@ApiTestConfig
class MaterialResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void create() {
        MaterialDto materialDto = new MaterialDto("001","floor",120,"wooden");
        this.webTestClient
                .post().uri(MaterialResource.MATERIALS)
                .body(BodyInserters.fromObject(materialDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(MaterialDto.class)
                .returnResult().getResponseBody();
        assertNotNull(materialDto);
        System.out.print(materialDto.getId());
        assertEquals("001",materialDto.getId());
        assertEquals("floor",materialDto.getName());
        assertEquals(120, materialDto.getPrice());
        assertEquals("wooden",materialDto.getType());
    }

    MaterialDto createMaterial(String id){
        MaterialDto materialDto = new MaterialDto(id,null,100,null);
        return this.webTestClient
                .post().uri(MaterialResource.MATERIALS)
                .body(BodyInserters.fromObject(materialDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(MaterialDto.class)
                .returnResult().getResponseBody();
    }

    @Test
    void delete() {
        String id = createMaterial("001").getId();
        System.out.print(id);
        this.webTestClient
                .delete().uri(MaterialResource.MATERIALS+MaterialResource.ID_ID,id)
                .exchange()
                .expectStatus().isOk();
    }


}