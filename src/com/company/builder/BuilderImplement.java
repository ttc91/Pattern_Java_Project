package com.company.builder;

class Person{

    private final String name;
    private final String address;
    private final String department;

    Person(String name, String address, String department) {
        this.name = name;
        this.address = address;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}

class Builder{

    private String name;
    private String address;
    private String department;

    public Builder yourName(String name){
        this.name = name;
        return this;
    }

    public Builder yourAddress(String address){
        this.address = address;
        return this;
    }

    public Builder yourDepartment(String department){
        this.department = department;
        return this;
    }

    public Person Build(){
        return new Person(name, address, department);
    }

}

public class BuilderImplement {

    public static void main(String[] args) {
        // write your code here

        Person person = new Builder().yourName("ttc").yourAddress("taiwan").yourDepartment("dev").Build();
        System.out.println(person);

    }

}
