package org.iti.mobile;

import java.time.LocalDateTime;
import java.util.List;

public class Employee {

   private long id;
    private String fName;
    private String lName;

    private String address;
    private LocalDateTime hiringDate;
    private double salary ;

    private List<String> departments;

    public Employee() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }



    public double increaseSalary(double salaryIncreaseValue){
         return  getSalary() + salaryIncreaseValue;
    }


    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }
}
