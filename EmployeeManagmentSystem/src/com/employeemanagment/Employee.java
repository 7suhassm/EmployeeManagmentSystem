package com.employeemanagment;

public class Employee {
	 private int id;
	    private String name;
	    private String email;
	    private double salary;
	    private String gender;
	    private String department;

	    public Employee(int id, String name, String email, double salary, String gender, String department) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.salary = salary;
	        this.gender = gender;
	        this.department = department;
	    }

	    // Getters
	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public String getDepartment() {
	        return department;
	    }

	    @Override
	    public String toString() {
	        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Salary: " + salary +
	               ", Gender: " + gender + ", Department: " + department;
	    }
}
