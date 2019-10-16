package es.upm.miw.apaw_ep_themes.dtos;

import es.upm.miw.apaw_ep_themes.exceptions.BadRequestException;

public class BuyerDto {

    private String id;

    private String name;

    private String address;

    private String bankAccount;

    public BuyerDto() {
    }

    public BuyerDto(String name, String address, String bankAccount) {
        this.name = name;
        this.address = address;
        this.bankAccount = bankAccount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void validate() {
        if (this.name == null || this.address == null || this.bankAccount == null) {
            throw new BadRequestException("Incomplete BuyerDto");
        }
    }
    @Override
    public String toString() {
        return "Buyer{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }
}
