package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Constructor;
import es.upm.miw.apaw_ep_themes.documents.House;

public class ConstructorDto {
    private String id;

    private String name;

    private Double price;

    private String business;

    private String worker;

    private House house;

    public ConstructorDto(Constructor constructor) {

    }

    public ConstructorDto(String name, Double price, String business, String worker, House house) {
        this.name = name;
        this.price = price;
        this.business = business;
        this.worker = worker;
        this.house = house;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
