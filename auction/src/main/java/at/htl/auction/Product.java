package at.htl.entity;

import java.util.List;

public class Product {
    String name;
    int newValue;
    List<Register>bidders;

    public Product(String name, int newValue) {
        this.name = name;
        this.newValue = newValue;
    }

    public void increase(int offer){
        if(newValue < offer){
            newValue = offer;
        }
    }
}
