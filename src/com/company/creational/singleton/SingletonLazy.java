package com.company.creational.singleton;

class LazyCount{

    private static LazyCount lc = new LazyCount();
    private static Integer count = 0;
    private LazyCount(){

    }

    public static LazyCount getInstance(){
        if (lc == null)
            lc = new LazyCount();
        return lc;
    }

    @Override
    public String toString() {
        count++;
        return String.valueOf(count);
    }
}

public class SingletonLazy {

    public static void main(String[] args){

        LazyCount lazy = LazyCount.getInstance();
        System.out.println(lazy);

    }

}
