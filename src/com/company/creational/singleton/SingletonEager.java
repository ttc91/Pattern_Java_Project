package com.company.creational.singleton;

class SingletonEg{

    private static SingletonEg se = new SingletonEg();
    private static Integer count = 0;
    private SingletonEg(){

    }

    public static SingletonEg getInstance(){
        return se;
    }

    @Override
    public String toString() {
        count++;
        return String.valueOf(count);
    }
}

public class SingletonEager {

    public static void main(String[] args){

        SingletonEg eg = SingletonEg.getInstance();
        System.out.println(eg);

        SingletonEg eg_1 = SingletonEg.getInstance();
        System.out.println(eg_1);

    }

}
