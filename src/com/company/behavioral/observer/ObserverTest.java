package com.company.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Subject</b> : which used to register observers. Objects use to this interface to register
 * <p>as observers and also to remove themselves from being observes</p>
 */

interface Subject {
    public void subscribeObserver(Observer observer);
    public void unSubscribeObserver(Observer observer);
    public void notifyObservers();
    public String subjectDetails();
}

interface Observer {
    public void update(String desc);
    public void subscribe();
    public void unSubscribe();
}

interface Commentary {
    public void setDesc(String desc);
}

enum SubjectDetails {
    PART_TIME,
    FULL_TIME,
    MANAGER,
    SECURITY
}

class DominoPizzaStore implements Subject, Commentary {

    private final List<Observer> observers;
    private String desc;
    private String subjectDetails;

    public DominoPizzaStore(List<Observer> observers, SubjectDetails details){
        this.observers = observers;

        switch (details){
            case MANAGER:
                this.subjectDetails = "Position of manager";
                break;
            case SECURITY:
                this.subjectDetails = "Position of security";
                break;
            case FULL_TIME:
                this.subjectDetails = "Position of full time employee";
                break;
            case PART_TIME:
                this.subjectDetails = "Position of part time employee";
                break;
            default:
                break;
        }

    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println();
        for (Observer observer : observers){
            observer.update(desc);
        }
    }

    @Override
    public String subjectDetails() {
        return subjectDetails;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
        notifyObservers();
    }
}

class ApplyPerson implements Observer {

    private final Subject subject;
    private String desc;
    private String personInfo;

    public ApplyPerson(Subject subject, String personInfo){

        if(subject == null){
            throw  new IllegalArgumentException("No publisher found");
        }
        this.personInfo = personInfo;
        this.subject = subject;
    }

    private void display() {
        System.out.println("[" + personInfo + "]: " +  desc);
    }

    @Override
    public void update(String desc) {
        this.desc = desc;
        display();
    }

    @Override
    public void subscribe() {
        System.out.println("Subscribing " + personInfo + " to " + subject.subjectDetails() + "...");
        this.subject.subscribeObserver(this);
        System.out.println("Subscribe successfully !");
    }

    @Override
    public void unSubscribe() {
        System.out.println("Unsubscribing " + personInfo + " to " + subject.subjectDetails() + "...");
        this.subject.unSubscribeObserver(this);
        System.out.println("Unsubscribe successfully !");
    }
}

public class ObserverTest {

    public static void main(String[] args) {
        // write your code here

        Subject subject = new DominoPizzaStore(new ArrayList<Observer>(), SubjectDetails.MANAGER);
        Observer observer = new ApplyPerson(subject, "Nguyen Van A (HCM)");
        observer.subscribe();

        System.out.println();

        Observer observer2 = new ApplyPerson(subject, "Tran Van B (HN)");
        observer2.subscribe();

        Commentary cObject = ((Commentary) subject);
        cObject.setDesc("Welcome to Domino's Pizza !");
        cObject.setDesc("Current position of pizza maker is empty !");

        System.out.println();

        observer2.unSubscribe();

        System.out.println();

    }

}
