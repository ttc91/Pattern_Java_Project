package com.company.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Strategy</b> : Declares an interface common to all supported algorithms. Context uses this interface to call the algorithms define by a ConcreteStrategy.
 */

interface Sort{
    public void executeSort();
}

/**
 * <b>Concrete Strategy</b> : Impl the algorithms using the Strategy interface.
 */
class MergeSort implements Sort{

    @Override
    public void executeSort() {
        System.out.println("Merge Sort !");
    }
}

class BubbleSort implements Sort{

    @Override
    public void executeSort() {
        System.out.println("Bubble Sort !");
    }
}

class SelectionSort implements Sort{

    @Override
    public void executeSort() {
        System.out.println("Selection Sort !");
    }
}

/**
 * <b>Context</b> :
 * <p>Is configured with a ConcreteStrategy object.</p>
 * <p>Maintains a reference to a Strategy object.</p>
 * <p>May define an interface that lets Strategy access its data.</p>
 */
class SortContext {

    private Sort sort;

    private List<Integer> list = new ArrayList<>();

    public void add(Integer integer){
        list.add(integer);
    }

    public void setSort(Sort sort){
        sort.executeSort();
    }

}

public class Strategy {

    public static void main(String[] args) {
        // write your code here

        SortContext context = new SortContext();
        context.add(1);
        context.add(3);
        context.add(7);

        context.setSort(new MergeSort());

    }

}
