package com.company.behavioral.state;

/**
 * <b>State</b> : Defines an interface for encapsulating the behavior associated with a particular state of the Context.
 */

interface PrintState{

    public void handleRequest() throws InterruptedException;

}

/**
 * <b>ConcreteState</b> : Each class implement behavior associated with a State of Context.
 */

class OnPrint implements PrintState{

    @Override
    public void handleRequest() throws InterruptedException {
        System.out.println("Printer is on...");
        Thread.sleep(1000);
    }
}

class ExecutingPrint implements PrintState{

    private String content;

    ExecutingPrint(String content){
        this.content = content;
    }

    @Override
    public void handleRequest() throws InterruptedException {
        System.out.println("Printer is executing...");
        Thread.sleep(1000);
        System.out.println("Content : " + content + " are printed !");
    }
}

class OffPrint implements PrintState{

    @Override
    public void handleRequest() throws InterruptedException {
        System.out.println("Printer is off...");
        Thread.sleep(1000);
    }
}

/**
 * <b>Context</b> :
 * <p>Defines the interface of interest to clients.</p>
 * <p>Maintains an instance of a ConcreteState subclass that defines the current state.</p>
 */

class PrintContext {

    private PrintState printState;

    public void setPrintState(PrintState printState){
        this.printState = printState;
    }

    public void applyState() throws InterruptedException {
        printState.handleRequest();
    }

}

public class State {

    public static void main(String[] args) {
        // write your code here

        PrintContext context = new PrintContext();
        context.setPrintState(new OnPrint());
        try {
            context.applyState();

            context.setPrintState(new ExecutingPrint("Hello"));
            context.applyState();

            context.setPrintState(new OffPrint());
            context.applyState();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
