package es.upm.miw.apaw_ep_themes.documents;

public class Material {
    private String id;
    private String name;
    private double price;
    private String type;

    public Material(String id, String name, double price, String type) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +'\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
