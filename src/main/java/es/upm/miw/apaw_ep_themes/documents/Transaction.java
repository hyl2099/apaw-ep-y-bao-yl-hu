package es.upm.miw.apaw_ep_themes.documents;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private LocalDateTime date;
    private String house;

    public Transaction(LocalDateTime date, String house) {
        this.date = date;
        this.house = house;
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

    public void validate() {
        if (date == null || house == null) {
            throw new BadRequestException("Incomplete Transaction. ");
        }
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
