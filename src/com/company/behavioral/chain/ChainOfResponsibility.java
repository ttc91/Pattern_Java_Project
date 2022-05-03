package com.company.behavioral.chain;

enum Language {

    MySQL("Database"),
    JavaSpring("Back-end"),
    Angular("Front-end");

    public String value;

    private Language (String value){
        this.value = value;
    }

}

class ChooseProgrammer {

    private Language language;

    public ChooseProgrammer(Language language){
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }
}

/**
 * <b>Handler</b> : Defines an interface for handling request.
 * <p>Implement the successor link.</p>
 */

abstract class LanguageProgrammer {

    protected LanguageProgrammer nextLanguageProgrammer;

    public void check(ChooseProgrammer chooseProgrammer){
        if(checkUsingProgrammer(chooseProgrammer.getLanguage())){
            useProgrammer();
        }else if (nextLanguageProgrammer != null){
            System.out.println(chooseProgrammer.getLanguage() + " is not correct this system - Changing into next checking...");
            nextLanguageProgrammer.check(chooseProgrammer);
        }else {
            System.out.println("Your request is not correct !");
        }
    }

    public void setNextLanguageProgrammer (LanguageProgrammer nextLanguageProgrammer){
        this.nextLanguageProgrammer = nextLanguageProgrammer;
    }

    protected abstract boolean checkUsingProgrammer(Language language);

    protected abstract void useProgrammer();

}

/**
 * <b>Concrete Handler</b> :
 * <p>Handles requests it is responsible for.</p>
 * <p>Can access its success.</p>
 * <p>If the Concrete Handler can handle the request, it does so; otherwise it forwards the request to its successor.</p>
 */

class JavaSpring extends LanguageProgrammer {

    @Override
    protected boolean checkUsingProgrammer(Language language) {

        System.out.println("Java System is checking your request...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(language == Language.JavaSpring){
            return true;
        }
        return false;

    }

    @Override
    protected void useProgrammer() {

        System.out.println("Your request can use by JavaSpring Programmer !");

    }
}

class Angular extends LanguageProgrammer {

    @Override
    protected boolean checkUsingProgrammer(Language language) {

        System.out.println("Angular System is checking your request...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(language == Language.Angular){
            return true;
        }

        return false;

    }

    @Override
    protected void useProgrammer() {

        System.out.println("Your request can use by Angular Programmer !");

    }
}

class MySQL extends LanguageProgrammer {

    @Override
    protected boolean checkUsingProgrammer(Language language) {

        System.out.println("MySQL System is checking your request...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(language == Language.MySQL){
            return true;
        }

        return false;

    }

    @Override
    protected void useProgrammer() {

        System.out.println("Your request can use by MySQL Programmer !");

    }
}

class CheckProgrammerWorkFlow {

    public static LanguageProgrammer getProgrammer () {

        LanguageProgrammer javaSpring = new JavaSpring();
        LanguageProgrammer angular = new Angular();
        LanguageProgrammer mySQL = new MySQL();

        javaSpring.setNextLanguageProgrammer(angular);
        angular.setNextLanguageProgrammer(mySQL);

        return javaSpring;
    }

}

public class ChainOfResponsibility {

    public static void main(String[] args) {
        // write your code here

        CheckProgrammerWorkFlow.getProgrammer().check(new ChooseProgrammer(Language.MySQL));

    }

}
