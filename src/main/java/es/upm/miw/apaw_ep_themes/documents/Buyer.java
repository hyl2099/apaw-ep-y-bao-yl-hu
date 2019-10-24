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


    @Override
    public String toString() {
        return "Buyer{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                '}';
    }

    public String getId() {
        return this.id;
    }
}
