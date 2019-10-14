package es.upm.miw.apaw_ep_themes.documents;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private LocalDateTime date;
    private String house;
    private List<Buyer> buyers;

    public Transaction(LocalDateTime date, String house) {
        this.date = date;
        this.house = house;
        this.buyers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", house=" + house +
                '}';
    }
}
