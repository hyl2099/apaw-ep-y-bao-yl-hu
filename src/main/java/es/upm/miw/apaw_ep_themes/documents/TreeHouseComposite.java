package es.upm.miw.apaw_ep_themes.documents;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TreeHouseComposite implements TreeHouse{
    private String id;
    private double price;
    private LocalDateTime dealDate;
    private double area;
    private Boolean isNew;

    private List<TreeHouse> treeHouseList;

    public TreeHouseComposite(double price, LocalDateTime dealDate, double area, Boolean isNew) {
        this.price = price;
        this.dealDate = dealDate;
        this.area = area;
        this.isNew = isNew;
        this.treeHouseList = new ArrayList<>();
    }

    @Override
    public String id() {
        return null;
    }

    @Override
    public double price() {
        return 0;
    }

    @Override
    public LocalDateTime dealDate() {
        return null;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public Boolean isNew() {
        return false;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeHouse treeHouse) {
        this.treeHouseList.add(treeHouse);
    }

    @Override
    public void remove(TreeHouse treeHouse) {
        this.treeHouseList.remove(treeHouse);
    }
}
