package com.company.structural.decorator;

/**
 * <b>Component</b> : Defines the interface fpr objects that can have responsibilities added to them dynamically.
 */

interface Pizza {

    public String getDesc();
    public double getPrice();

}

/**
 * <b>Concrete Component</b> : Defines an object to which additional responsibilities can be attached.
 */

class SimplyVegPizza implements Pizza {

    @Override
    public String getDesc() {
        return "SimplyVegPizza (250)";
    }

    @Override
    public double getPrice() {
        return 250;
    }
}

class SimpleNonVegPizza implements  Pizza {

    @Override
    public String getDesc() {
        return "SimplyNonVegPizza (350)";
    }

    @Override
    public double getPrice() {
        return 350;
    }
}

/**
 * <b>Decorator</b> : Maintains a references to a Component object and defines an interface that conforms to Component's interface.
 */

abstract class DecorPizza implements Pizza {

    @Override
    public String getDesc() {
        return "Topping";
    }
}

/**
 * <b>Concrete Decorate</b> : Adds responsibilities to the components
 */

class Chicken extends DecorPizza {

    private Pizza pizza;

    public Chicken (Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return this.pizza.getDesc() + ", Chicken (100)";
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice() + 100;
    }
}

class Ham extends DecorPizza {

    private Pizza pizza;

    public Ham (Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return this.pizza.getDesc() + ", Ham (120)";
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice() + 120;
    }
}


class Onion extends DecorPizza {

    private Pizza pizza;

    public Onion (Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return this.pizza.getDesc() + ", Onion (50)";
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice() + 50;
    }
}

public class Decorator {

    public static void main(String[] args) {
        // write your code here

        Pizza pizza = new SimpleNonVegPizza();

        System.out.println(pizza.getDesc());
        System.out.println(pizza.getPrice());

        pizza = new Chicken(pizza);

        System.out.println(pizza.getDesc());
        System.out.println(pizza.getPrice());

    }

}
