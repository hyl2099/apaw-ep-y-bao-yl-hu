package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Transaction;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.time.LocalDateTime;

public class TransactionDto {
    private String id;
    private LocalDateTime date;
    private String house;

    public TransactionDto() {
    }

    public TransactionDto(Transaction transaction) {
        this.id = transaction.getId();
        this.date = transaction.getDate();
        this.house = transaction.getHouse();
    }

    public TransactionDto(LocalDateTime date, String house) {
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
            throw new BadRequestException("Incomplete TransactionDto. ");
        }
    }

    public void validateHouse() {
        if (this. house == null || this. house.isEmpty()) {
            throw new BadRequestException("Incomplete, lost  house");
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
