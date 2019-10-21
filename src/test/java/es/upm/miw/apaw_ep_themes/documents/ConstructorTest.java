package es.upm.miw.apaw_ep_themes.documents;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorTest {
    private Constructor constructor = new Constructor("001","ODG", (double) 100,"reform","Yuling",new House(100, LocalDateTime.of(2017, Month.JANUARY, 4, 17, 23, 52),116.0,false));
    @Test
    void testToString() {
        constructor.toString();
        System.out.print(constructor.toString());
        assertEquals("Constructor{id='001', name='ODG', price=100.0, business='reform', worker='Yuling', house=House{, price=100.0, dealDate='2017-01-04T17:23:52', area='116.0', isNew='false'}}", constructor.toString());
    }
}