package es.upm.miw.apaw_ep_themes.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialDtoTest {
    private MaterialDto materialDto = new MaterialDto(null,"floor",100,"wooden");

    @Test
    void setId() {
        this.materialDto.setId("001");
        assertEquals("001", materialDto.getId());
    }

    @Test
    void getName() {
        assertEquals("floor", materialDto.getName());
    }

    @Test
    void setName() {
        this.materialDto.setName("brick");
        assertEquals("brick", materialDto.getName());
    }

    @Test
    void getPrice() {
        assertEquals(100, materialDto.getPrice());
    }

    @Test
    void setPrice() {
        this.materialDto.setPrice(200);
        assertEquals(200, materialDto.getPrice());
    }

    @Test
    void getType() {
        assertEquals("wooden", materialDto.getType());
    }

    @Test
    void setType() {
        this.materialDto.setType("stone");
        assertEquals("stone", materialDto.getType());
    }
}