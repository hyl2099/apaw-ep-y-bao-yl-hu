package es.upm.miw.apaw_ep_themes.documents;

public class Buyer {


    private String id;

    private String name;

    private String address;

    private String bankAccount;

    public Buyer(String name, String address,String bankAccount) {
        this.name = name;
        this.address = address;
        this.bankAccount = bankAccount;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
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
