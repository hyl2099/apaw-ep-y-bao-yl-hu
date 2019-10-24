package es.upm.miw.apaw_ep_themes.documents;

public class SellerBuilder {

    private String name;

    private Integer credit;


    public SellerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SellerBuilder setCredit(Integer credit) {
        this.credit = credit;
        return this;
    }

    public Seller build(){
        return new Seller(name, credit);
    }
}
