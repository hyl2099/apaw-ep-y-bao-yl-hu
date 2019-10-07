package apaw.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Seller {

    @Id
    private String id;

    private String name;

    private Integer credit;

    public Seller(String name, Integer credit) {
        this.name = name;
        this.credit = credit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", credit='" + credit + '\'' +
                '}';
    }
}