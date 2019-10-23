package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.House;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

import java.time.LocalDateTime;

public class HouseDto {

    private String id;
    private double price;
    private LocalDateTime dealDate;
    private double area;
    private Boolean isNew;

    public HouseDto() {
        // empty for framework
    }

    public HouseDto(House house) {
        this.id = house.getId();
        this.price = house.getPrice();
        this.dealDate = house.getDealDate();
        this.area = house.getArea();
        this.isNew = house.getISNew();
    }

    public HouseDto(double price, LocalDateTime dealDate, double area, boolean isNew) {
        this.price = price;
        this.dealDate = dealDate;
        this.area = area;
        this.isNew = isNew;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDealDate() {
        return dealDate;
    }

    public void setDealDate(LocalDateTime dealDate) {
        this.dealDate = dealDate;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public void validate() {
        if (price == 0 || dealDate == null || area==0 || isNew ==null) {
            throw new BadRequestException("Incomplete HouseDto. ");
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", dealDate='" + dealDate + '\'' +
                ", area='" + area + '\'' +
                ", isNew='" + isNew + '\'' +
                '}';
    }
}
