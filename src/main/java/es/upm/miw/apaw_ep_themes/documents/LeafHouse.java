package es.upm.miw.apaw_ep_themes.documents;


import java.time.LocalDateTime;

public class LeafHouse implements TreeHouse{
    private House house;

    public LeafHouse(House house) {
        this.house = house;
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
        return null;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeHouse treeHouse) {
        // Do nothing because is leaf
    }

    @Override
    public void remove(TreeHouse treeHouse) {
        // Do nothing because is leaf
    }
}
