package at.htl.entity;

import java.util.LinkedList;
import java.util.List;

public class Register {
    Salesperson seller;
    List<Product> products;
    List<Offer>offers;

    public Register(Salesperson seller, LinkedList<Product> products) {
        this.seller = seller;
        this.products = products;
    }
}
