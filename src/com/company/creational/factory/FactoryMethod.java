package com.company.creational.factory;

/**
 * <b>Interface product</b> : Defines the interface of objects the factory method creates
 */

interface Drink {

    public String order();

}

/**
 * <b>Concrete product</b> : implement the Product interface
 */

class Coffee implements Drink{

    @Override
    public String order() {

        System.out.println("Your coffee is ordered");
        System.out.println("Waiting for little minutes !");
        return "Coffee is completed !";

    }
}

class Juice implements Drink {

    @Override
    public String order() {
        System.out.println("Your juice is ordered");
        System.out.println("Waiting for little minutes !");
        return "Juice is completed !";
    }
}

/**
 * <b>Creator</b> : Declare the factory method, which <b>returns an object of type Product</b>. Create
 * may also define a default implementation of the factory method that returns a default <b>ConcreteProduct</b> object.
 */

abstract class OrderDrinkService{

    public void takeDrink(){
        Drink drink = getDrink();
        drink.order();
    }

    protected abstract Drink getDrink();

}

/**
 * <b>Concrete Creator</b> : Overrides the factory method to return an instance of a Concrete product
 */

class OrderCoffeeService extends OrderDrinkService{

    @Override
    protected Drink getDrink() {
        return new Coffee();
    }
}

class OrderJuiceService extends OrderDrinkService{

    @Override
    protected Drink getDrink() {
        return new Juice();
    }
}

public class FactoryMethod {

    public static void main(String[] args){


        OrderDrinkService service = new OrderCoffeeService();
        service.takeDrink();

    }

}
