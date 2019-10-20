package es.upm.miw.apaw_ep_themes.dtos;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class TransactionDtoTest {
    private TransactionDto transactionDto = new TransactionDto(LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52),"001");

    @Test
    void getDate() {
        assertEquals( LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52), transactionDto.getDate());
    }

    @Test
    void setDate() {
        this.transactionDto.setDate(LocalDateTime.of(2019, Month.JANUARY, 4, 17, 23, 52));
        assertEquals( LocalDateTime.of(2019, Month.JANUARY, 4, 17, 23, 52), transactionDto.getDate());
    }

    @Test
    void getHouse() {
        assertEquals("001", transactionDto.getHouse());
    }

    @Test
    void setHouse() {
        this.transactionDto.setHouse("002");
        assertEquals("002", transactionDto.getHouse());
    }

}