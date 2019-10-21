package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.House;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorDtoTest {
    ConstructorDto constructorDto = new ConstructorDto("ODG", 100.0,"reform","Yuling",new House(100,LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52),116.0,false));
    @Test
    void getId() {
        assertEquals(null, constructorDto.getId());
    }


    @Test
    void getName() {
        assertEquals("ODG", constructorDto.getName());
    }

    @Test
    void setName() {
        this.constructorDto.setName("BB");
        assertEquals("BB", constructorDto.getName());
    }


    @Test
    void getBusiness() {
        assertEquals("reform", constructorDto.getBusiness());
    }

    @Test
    void setBusiness() {
        this.constructorDto.setBusiness("AA");
        assertEquals("AA", constructorDto.getBusiness());
    }

    @Test
    void getWorker() {
        assertEquals("Yuling", constructorDto.getWorker());
    }

    @Test
    void setWorker() {
        this.constructorDto.setWorker("AA");
        assertEquals("AA", constructorDto.getWorker());
    }

}