package com.company.behavioral.command;

/**
 * <b>Command</b> : Declares an interface for executing an operation.
 */

interface Command {
    public void execute();
}

/**
 * <b>Receiver</b> : Knows how to perform the operations associated with carrying out a request.
 * <p>Any class may serve as a Receiver.</p>
 */

class Device {

    private String message;

    public Device(){}

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void openSmsApp(){
        System.out.println("Your sms app is opening...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void writeSmsMessage() throws InterruptedException {
        System.out.println("System is writing your message...");
        Thread.sleep(2000);
    }

    public void closeSmsApp(){
        System.out.println("Your sms app is closing...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * <b>Concrete Command</b> :
 * <p>Defines a binding between a Receiver object and an action.</p>
 * <p>Implement execute by invoking by corresponding operation(s) on Receiver</p>
 */

class OpenSmsCommand implements Command{

    Device device;

    public OpenSmsCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.openSmsApp();
        System.out.println("Your sms app is opened !");
    }
}

class WriteSmsCommand implements Command{

    Device device;

    public WriteSmsCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        try {
            device.writeSmsMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Your message is : '" + device.getMessage() + "' is written !");
    }
}

class CloseSmsCommand implements Command{

    Device device;

    public CloseSmsCommand(Device device){
        this.device = device;
    }

    @Override
    public void execute() {
        device.closeSmsApp();
        System.out.println("Your sms app is closed !");
    }
}

/**
 * <b>Invoker</b> : Asks the command to carry out the request.
 */

class SmsApp {

    private OpenSmsCommand open;
    private WriteSmsCommand write;
    private CloseSmsCommand close;

    public SmsApp(OpenSmsCommand open, WriteSmsCommand write, CloseSmsCommand close){
        this.open = open;
        this.write = write;
        this.close = close;
    }

    public void clickOpenSmsApp() {
        open.execute();
    }

    public void clickWriteSmsMessage(){
        write.execute();
    }

    public void clickCloseSmsApp(){
        close.execute();
    }

}

public class CommandTest {

    public static void main(String[] args) {
        // write your code here

        Device device = new Device();
        device.setMessage("Helloooooo !!!");

        Command open = new OpenSmsCommand(device);
        Command write = new WriteSmsCommand(device);
        Command close = new CloseSmsCommand(device);

        SmsApp smsApp = new SmsApp((OpenSmsCommand) open, (WriteSmsCommand) write, (CloseSmsCommand) close);
        smsApp.clickOpenSmsApp();
        smsApp.clickWriteSmsMessage();
        smsApp.clickCloseSmsApp();

    }

}
