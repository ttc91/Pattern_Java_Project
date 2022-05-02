package com.company.behavioral.mediator;

/**
 * <b>Mediator</b> : Defines an interface for communicating with Colleague object.
 */
interface MachineMediator{

    public void start();
    public void wash();
    public void open();
    public void closed();
    public void on();
    public void off();
    public boolean checkTemperature(int temp);

}

/**
 * <b>Colleague</b> : Each colleague class knows its Media object. Each colleague communicates with its
 * <p>mediator whenever it would have otherwise communicated with another colleague</p>
 */

interface Colleague {

    public void setMediator (MachineMediator mediator);

}

/**
 * <b>Concrete Colleague</b>
 */

class Button implements Colleague{

    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void press() {
        System.out.println("Button pressed.");
        mediator.start();
    }

}

class Machine implements Colleague {

    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void start(){
        mediator.open();
    }

    public void wash(){
        mediator.wash();
    }

}

class Valve implements Colleague {

    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void open(){
        System.out.println("Valve is opened...");
        System.out.println("Filling water...");
        mediator.closed();
    }

    public void closed(){
        System.out.println("Valve is closed...");
        mediator.on();
    }

}

class Heater implements Colleague {

    private MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator) {
        this.mediator = mediator;
    }

    public void on(int temp){
            System.out.println("Heater is off...");
            if(mediator.checkTemperature(temp)){
                System.out.println("Temperature is set to " + temp);
                mediator.off();
            }
    }

    public void off(){
        System.out.println("Heater is off...");
        mediator.wash();
    }

}

/**
 * <b>ConcreteMediator</b> : Implements cooperative behavior by coordinating Colleague object. It also knows the maintains its colleague
 */

class CottonMediator implements MachineMediator {

    private final Machine machine;
    private final Heater heater;
    private final Sensor sensor;
    private final SoilRemoval soilRemoval;
    private final Valve valve;

    public CottonMediator(Machine machine, Heater heater, Sensor sensor, SoilRemoval soilRemoval, Valve valve) {

        this.machine = machine;
        this.heater = heater;
        this.sensor = sensor;
        this.soilRemoval = soilRemoval;
        this.valve = valve;

        System.out.println("Setting up for COTTON program");
    }

    @Override
    public void start() {
        machine.start();
    }

    @Override
    public void wash() {

        System.out.println("Adding detergent");
        System.out.println("Adding softener");

    }

    @Override
    public void open() {
        valve.open();
    }

    @Override
    public void closed() {
        valve.closed();
    }

    @Override
    public void on() {
        heater.on(40);
    }

    @Override
    public void off() {
        heater.off();
    }

    @Override
    public boolean checkTemperature(int temp) {
        return sensor.checkTemperature(temp);
    }
}

class Sensor{

    public boolean checkTemperature(int temp){
        System.out.println("Temperature reached " + temp + " *C");
        return true;
    }

}

class SoilRemoval {

    public void low(){
        System.out.println("Setting Soil Removal to low");
    }

    public void medium(){
        System.out.println("Setting Soil Removal to medium");
    }

    public void high(){
        System.out.println("Setting Soil Removal to high");
    }

}

class DenimMediator implements MachineMediator {

    private final Machine machine;
    private final Heater heater;
    private final Sensor sensor;
    private final SoilRemoval soilRemoval;
    private final Valve valve;

    public DenimMediator(Machine machine, Heater heater, Sensor sensor, SoilRemoval soilRemoval, Valve valve) {

        this.machine = machine;
        this.heater = heater;
        this.sensor = sensor;
        this.soilRemoval = soilRemoval;
        this.valve = valve;

        System.out.println("Setting up for DENIM program");

    }

    @Override
    public void start() {
        machine.start();
    }

    @Override
    public void wash() {
        System.out.println("Adding detergent");
        System.out.println("Adding softener");
    }

    @Override
    public void open() {
        valve.open();
    }

    @Override
    public void closed() {
        valve.closed();
    }

    @Override
    public void on() {
        heater.on(30);
    }

    @Override
    public void off() {
        heater.off();
    }

    @Override
    public boolean checkTemperature(int temp) {
        return sensor.checkTemperature(temp);
    }
}

public class Mediator {

    public static void main(String[] args) {
        // write your code here

        MachineMediator mediator = null;
        Sensor sensor = new Sensor();
        SoilRemoval soilRemoval = new SoilRemoval();
        Machine machine = new Machine();
        Heater heater = new Heater();
        Valve valve = new Valve();
        Button button = new Button();

        mediator = new CottonMediator(machine, heater, sensor, soilRemoval, valve);

        button.setMediator(mediator);
        machine.setMediator(mediator);
        heater.setMediator(mediator);
        valve.setMediator(mediator);
        button.press();

        mediator = new DenimMediator(machine, heater, sensor, soilRemoval, valve);

        button.setMediator(mediator);
        machine.setMediator(mediator);
        heater.setMediator(mediator);
        valve.setMediator(mediator);
        button.press();

    }





}
