package es.upm.miw.apaw_ep_themes.documents;

public class Constructor {

    private String id;

    private String name;

    private Double price;

    private String business;

    private String worker;

    private House house;

    public Constructor() {
    }

    public Constructor(String id, String name, Double price, String business, String worker, House house) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.business = business;
        this.worker = worker;
        this.house = house;
    }

    @Override
    public String toString() {
        return "Constructor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", business='" + business + '\'' +
                ", worker='" + worker + '\'' +
                ", house=" + house +
                '}';
    }
}

