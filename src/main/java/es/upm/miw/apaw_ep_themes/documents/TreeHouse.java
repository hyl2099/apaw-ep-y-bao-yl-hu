package es.upm.miw.apaw_ep_themes.documents;

import java.time.LocalDateTime;

public interface TreeHouse {
    String id();
    double price();
    LocalDateTime dealDate();
    double area();
    Boolean isNew();
    boolean isComposite();
    void add(TreeHouse treeHouse) ;
    void remove(TreeHouse treeHouse) ;
}
