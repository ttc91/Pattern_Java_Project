package com.company.structural.bridge;

interface Product {

    public void getProductName();
    public void produceName ();

}

abstract class Pizza {

    private final Product product;

    protected Pizza(Product product) {
        this.product = product;
    }

    public abstract void getPizzaItem(Product product);
    public abstract void getItemProducer();

    public void getPizzaStore() {
        System.out.println("Domino's Pizza !!!");
    }

}

class Shrimp implements Product {

    @Override
    public void getProductName() {
        System.out.println("Shrimp");
    }

    @Override
    public void produceName() {
        System.out.println("CatLai produce Shrimp to make pizza !");
    }
}

class OceanMania extends Pizza {

    private Product product;

    protected OceanMania(Product product) {
        super(product);

        this.product = product;

    }

    @Override
    public void getPizzaItem(Product product) {
        product.getProductName();
    }

    @Override
    public void getItemProducer() {
        product.produceName();
    }

}


public class Bridge {

    public static void main(String[] args) {
        // write your code here

        Product product = new Shrimp();
        Pizza pizza = new OceanMania(product);
        pizza.getItemProducer();
        pizza.getPizzaItem(product);
        pizza.getPizzaStore();

    }

}
