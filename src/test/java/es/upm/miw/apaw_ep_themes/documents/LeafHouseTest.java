package es.upm.miw.apaw_ep_themes.documents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeafHouseTest {
    House house = new House();
    LeafHouse leaf = new LeafHouse(house);

    @Test
    void id() {
        assertEquals(null,leaf.id());
    }

    @Test
    void price() {
        assertEquals(0,leaf.price());
    }

    @Test
    void dealDate() {
        assertEquals(null,leaf.dealDate());
    }

    @Test
    void area() {
        assertEquals(0,leaf.area());
    }

    @Test
    void isNew() {
        assertEquals(null,leaf.isNew());
    }

    @Test
    void isComposite() {
        assertEquals(false,leaf.isComposite());
    }

}