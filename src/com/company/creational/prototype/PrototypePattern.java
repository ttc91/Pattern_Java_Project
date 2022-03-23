package com.company.creational.prototype;

import java.util.HashMap;
import java.util.Map;

interface Prototype extends Cloneable{

    public Computer clone() throws CloneNotSupportedException;

}

class Computer implements Prototype{

    private String os;
    private String office;
    private String antivirus;
    private String browsers;
    private String others;

    public Computer(String os, String office, String antivirus, String browsers, String others) {
        this.os = os;
        this.office = office;
        this.antivirus = antivirus;
        this.browsers = browsers;
        this.others = others;
    }

    @Override
    public Computer clone() throws CloneNotSupportedException {
        try{
            return (Computer) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "os='" + os + '\'' +
                ", office='" + office + '\'' +
                ", antivirus='" + antivirus + '\'' +
                ", browsers='" + browsers + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}



public class PrototypePattern {

    public static void main (String[] args){

        Computer computer1 = new Computer("Linux", "Office 365", "No", "Google Chrome","No" );
        System.out.println(computer1);
        try {
            Computer computer2 = computer1.clone();
            computer2.setOthers("VS Code, PyCharm");
            System.out.println(computer2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }

}
