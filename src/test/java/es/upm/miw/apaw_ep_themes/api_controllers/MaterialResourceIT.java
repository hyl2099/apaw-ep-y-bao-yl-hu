package es.upm.miw.apaw_ep_themes.api_controllers;

import es.upm.miw.apaw_ep_themes.ApiTestConfig;
import es.upm.miw.apaw_ep_themes.dtos.MaterialDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;


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

    @Test
    void testCreateMaterialException() {
        MaterialDto materialDto = new MaterialDto(null,null,0,"wooden");
        this.webTestClient
                .post().uri(MaterialResource.MATERIALS)
                .body(BodyInserters.fromObject(materialDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    MaterialDto createMaterial(String id){
        MaterialDto materialDto = new MaterialDto(id,"Floor",100,null);
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
        this.webTestClient
                .delete().uri(MaterialResource.MATERIALS+MaterialResource.ID_ID,id)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void deleteException() {
        String id = null;
        this.webTestClient
                .delete().uri(MaterialResource.MATERIALS+MaterialResource.ID_ID,id)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testPatchMaterial() {
        MaterialDto materialDto = new MaterialDto("001","floor",120,"wooden");
        this.webTestClient
                .post().uri(MaterialResource.MATERIALS)
                .body(BodyInserters.fromObject(materialDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(MaterialDto.class)
                .returnResult().getResponseBody();

        MaterialDto newMaterial = new MaterialDto();
        newMaterial.setName("Brick");
        this.webTestClient
                .patch().uri(MaterialResource.MATERIALS + MaterialResource.ID_ID, materialDto.getId())
                .body(BodyInserters.fromObject(newMaterial))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testPatchMaterialException() {
        MaterialDto materialDto = new MaterialDto("001","Yuling",120,"wooden");
        this.webTestClient
                .post().uri(MaterialResource.MATERIALS)
                .body(BodyInserters.fromObject(materialDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(MaterialDto.class)
                .returnResult().getResponseBody();

        MaterialDto newMaterial = new MaterialDto();
        newMaterial.setName(null);
        this.webTestClient
                .patch().uri(MaterialResource.MATERIALS + MaterialResource.ID_ID, materialDto.getId())
                .body(BodyInserters.fromObject(newMaterial))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}