package com.company.creational.factory;


/**
 * <b>Abstract product</b> : Declares an interface for a type of product object.
 */

interface Shape{
    void draw();
}

/**
 * <b>Concrete product</b> :
 * <p>Defines a product object to be created by the corresponding concrete factory</p>
 * <p>Implement the Abstract product interface</p>
 */

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

/**
 * <b>Abstract factory</b> : Declares an interface for operations that create abstract product objects
 */

abstract class AbstractShapeFactory{

    public abstract Shape drawShape(String shapeType);

}

/**
 * <b>Concrete factory</b> : Implements the operations to create concrete product objects
 */

class RectangleFactory extends AbstractShapeFactory{

    @Override
    public Shape drawShape(String shapeType) {
        switch (shapeType){

            case "CIRCLE" : return new Circle();
            case "RECTANGLE" : return new Rectangle();

        }
        return null;
    }
}

class CircleFactory extends AbstractShapeFactory{

    @Override
    public Shape drawShape(String shapeType) {

        switch (shapeType){

            case "CIRCLE" : return new Circle();
            case "RECTANGLE" : return new Rectangle();

        }
        return null;

    }
}

/**
 * <b>Factory producer</b> :  generator/producer class to get factories by passing an information
 */

class ShapeFactoryProducer {



    public static AbstractShapeFactory getShapeFactory(String shapeType){

        switch (shapeType){
            case "CIRCLE_FACTORY" : return new CircleFactory();
            case "RECTANGLE_FACTORY" : return new RectangleFactory();
        }

        return null;
    }

}

public class AbstractFactory {

    public static void main(String[] args){

        AbstractShapeFactory factory = ShapeFactoryProducer.getShapeFactory("CIRCLE_FACTORY");
        Shape shape = factory.drawShape("CIRCLE");
        shape.draw();

    }

}
