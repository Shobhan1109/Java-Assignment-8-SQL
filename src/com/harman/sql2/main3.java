package com.harman.sql2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int options;
        while (true){
            System.out.println("\nChoose the option:");
            System.out.println("1.Add a new employee.");
            System.out.println("2.view all the employees.");
            System.out.println("3.EXIT.");
            options=s.nextInt();
            switch (options){
                case 1:
                    String name,phoneno,email,designation,salary,companyname,address;
                    System.out.println("Enter the Employee name:");
                    name=s.next();
                    System.out.println("Enter the Phone number");
                    phoneno=s.next();
                    System.out.println("Enter the Email:");
                    email=s.next();
                    System.out.println("Enter the Designation:");
                    designation=s.next();
                    System.out.println("Enter the Salary:");
                    salary=s.next();
                    System.out.println("Enter the Comapny name: ");
                    companyname=s.next();
                    System.out.println("Enter the Address:");
                    address=s.next();
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false","root","");
                        Statement stm = c.createStatement();
                        stm.executeUpdate("INSERT INTO `employees`( `Name`, `Phone number`, `Email`, `Designation`, `Salary`, `Company name`, `Address`) VALUES('"+name+"','"+phoneno+"','"+email+"','"+designation+"',"+salary+",'"+companyname+"','"+address+"')");
                        System.out.println("Inserted successfully.");
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try{
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/companydb?autoReconnect=true&useSSL=false","root","");
                        Statement stm = c.createStatement();
                        ResultSet r = stm.executeQuery("SELECT `empcode`, `Name`, `Phone number`, `Email`, `Designation`, `Salary`, `Company name`, `Address` FROM `employees` WHERE 1");
                        while(r.next()){
                            System.out.println("\nEmployee code: "+r.getInt("empcode"));
                            System.out.println("Employee name: "+r.getString("Name"));
                            System.out.println("Employee Phone number: "+r.getString("Phone number"));
                            System.out.println("Employee Email: "+r.getString("Email"));
                            System.out.println("Employee Designation: "+r.getString("Designation"));
                            System.out.println("Employee salary: "+r.getInt("Salary"));
                            System.out.println("Employee Comapny name: "+r.getString("Company name"));
                            System.out.println("Employee Address: "+r.getString("Address"));

                        }


                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("invalid entry !");
            }
        }
    }
}
