package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.documents.Seller;
import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class SellerDto {

    private String id;

    private String name;

    private Integer credit;

    public SellerDto() {
        // empty for framework
    }

    public SellerDto(String name, Integer credit) {
        this.name = name;
        this.credit = credit;
    }

    public SellerDto(Seller seller) {
        this.id = seller.getId();
        this.name = seller.getName();
        this.credit = seller.getCredit();
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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public void validate() {
        if (name == null || credit == null ) {
            throw new BadRequestException("Incomplete SellerDto. ");
        }
    }

    @Override
    public String toString() {
        return "SellerDto{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", credit='" + credit + '\'' +
                '}';
    }
}
