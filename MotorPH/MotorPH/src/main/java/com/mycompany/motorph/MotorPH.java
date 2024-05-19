/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.motorph;

import java.util.Scanner;

/**
 *
 * @author Birondo
 */
public class MotorPH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("***********************************************");
        System.out.println("        Motor PH Main Menu      ");
        System.out.println("***********************************************");
        System.out.println("1: List of Employee Records     ");
        System.out.println("2: Calculate Net Salary         ");
        System.out.println("3: Calculate Salary based on Hours Worked ");
        System.out.println("************************************************");
        try ( /**
         * Creates an object of Scanner Resource from Camu:
         * https://www.programiz.com/java-programming/scanner
         */ Scanner input = new Scanner(System.in)) {
            System.out.print("Pleas choose the screen you would like to view: ");
            // takes input from the keyboard
            String option = input.nextLine();
            // prints the option
            // System.out.println("You entered option number: " + option);
            processOption(option);
            // closes the scanner
        }
    }

    private static void processOption(String option) {
        //Used conditional branch "switch" statement
        switch (option) {
            case "1" -> processListOfEmployees();
            case "2" -> calculateNetSalary();
            case "3" -> salaryOnHoursWorked();
            default -> {
            }
        }
    }

    //method that has "void" signature doesn't return a data type
    private static void processListOfEmployees() {
        //Instanciating new object
        EmployeeModel employeeModel = new EmployeeModel();
        //Getting the list of employees
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #1");
        System.out.println("             List of employees        ");
        System.out.println("***********************************************");
        //used for loop statement to iterate thru the list of employees
        for (Employee employee : employeeList) {
            System.out.print("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Position: " + employee.getPosition() + "\n");
        }
    }

    private static void calculateNetSalary() {
        //Instanciating new object
        EmployeeModel employeeModel = new EmployeeModel();
        //Getting the list of employees
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryDeductions salaryDeductions = new SalaryDeductions();
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #2    ");
        System.out.println("          Employee Net Salaries      ");
        System.out.println("***********************************************");
        //used for loop statement to iterate thru the list of employees
        for (Employee employee : employeeList) {
            System.out.print("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Basic Salary: " + employee.getBasicSalary()
                    + ", Net Salary: " + (employee.getBasicSalary() - salaryDeductions.getTotalDeductions(employee.getBasicSalary())) + "\n");
        }
    }

    private static void salaryOnHoursWorked() {
        //Instanciating new object
        EmployeeModel employeeModel = new EmployeeModel();
        //Getting the list of employees
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryOnHoursWorked hoursWOrked = new SalaryOnHoursWorked();
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #3        ");
        System.out.println("     Salaries based on hours worked      ");
        System.out.println("***********************************************");
        //used for loop statement to iterate thru the list of employees
        for (Employee employee : employeeList) {
            System.out.print("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Basic Salary: " + employee.getBasicSalary()
                    + ", Salary Based on Hours Worked: " + hoursWOrked.getSalaryOnHoursWorked(employee.getHourlyRate()) + "\n");
        }
    }
}
