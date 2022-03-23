package com.company.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Parameter class</b> :
 */

class Code {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

/**
 * <b>Flyweight</b> : Declares an interface through which flyweights can receive and act on extrinsic state.
 */

interface Platform {
    public void executed (Code code);
}

/**
 * <b>Concrete Flyweight</b> : Implements the Flyweight interface and adds storage for intrinsic state, if any.
 * <b>A ConcreteFlyweight object must be sharable</b>. Any state it sotres must be intrinsic; that is, it must be independence of the ConcreteFlyweight object's context.
 */

class JavaPlatform implements Platform {

    public JavaPlatform (){
        System.out.println("Java platform is created !");
    }

    @Override
    public void executed(Code code) {
        System.out.println("Compiling and executing Java code ...");
    }

}

class PythonPlatform implements Platform{

    public PythonPlatform (){
        System.out.println("Python platform is created !");
    }

    @Override
    public void executed(Code code) {
        System.out.println("Compiling and executing Python code ...");
    }

}

/**
 * <b>Flyweight Factory</b> : Creates and manages flyweight objects.
 */

class PlatformFactory{

    private static Map<String, Platform> platformHashMap = new HashMap<>();

    private PlatformFactory (){
        throw new AssertionError("Cannot instantiate the class");
    }

    public static Platform getPlatform(String name){

        Platform platform = platformHashMap.get(name);

        if (platform == null){
            switch (name){
                case "Java" :
                    platform =  new JavaPlatform();
                    break;
                case "Python" :
                    platform = new PythonPlatform();
                    break;
                default:
                    return null;
            }
        }
        return platform;

    }

}

public class Flyweight {

    public static void main(String[] args) {
        // write your code here

        Platform platform = PlatformFactory.getPlatform("Java");

    }

}
