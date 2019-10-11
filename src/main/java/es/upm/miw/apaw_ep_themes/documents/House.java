package es.upm.miw.apaw_ep_themes.documents;

import java.time.LocalDateTime;

public class House {
    private String id;
    double price;
    LocalDateTime dealDate;
    double area;
    Boolean isNew;

    public House(double price, LocalDateTime dealDate, double area, Boolean isNew) {
        this.price = price;
        this.dealDate = dealDate;
        this.area = area;
        this.isNew = isNew;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDealDate() {
        return dealDate;
    }

    public double getArea() {
        return area;
    }

    public Boolean getISNew() {
        return isNew;
    }

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
