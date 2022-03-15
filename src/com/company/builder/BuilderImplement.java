package com.company.builder;

class Employee{

    private final String firstName;
    private final String lastName;
    private final int startTime;
    private final int endTime;
    private final String department;


    Employee(String firstName, String lastName, int startTime, int endTime, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", department='" + department + '\'' +
                '}';
    }
}

class Builder{

    private String firstName;
    private String lastName;
    private int startTime;
    private int endTime;
    private String department;

    public Builder firstName (String firstName){
        this.firstName = firstName;
        return this;
    }

    public Builder lastName (String lastName){
        this.lastName = lastName;
        return this;
    }

    public Builder startTime(int startTime){
        this.startTime = startTime;
        return this;
    }

    public Builder endTime(int endTime){
        this.endTime = endTime;
        return this;
    }

    public Builder department(String department){
        this.department = department;
        return this;
    }

    public Employee Build(){
        return new Employee(firstName, lastName, startTime, endTime, department);
    }

}

public class BuilderImplement {

    public static void main(String[] args) {
        // write your code here
        Employee e = new Builder().lastName("tat tan").firstName("tat").startTime(1).endTime(10).department("taiwan").Build();

        System.out.println(e);
    }

}
