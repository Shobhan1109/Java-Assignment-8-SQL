package com.harman.sql2;
import java.sql.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int options;
        while (true) {
            System.out.println("Enter the option:");
            System.out.println("\n1. Add a phone");
            System.out.println("2. view all phone");
            System.out.println("3. Search a phone");
            System.out.println("4. Edit a phone data");
            System.out.println("5. Delete a phone");
            System.out.println("6. Exit");
            options = s.nextInt();
            switch (options) {
                case 1:
                    String imei, brand, model, price;
                    System.out.println("Enter the phone's imei number:");
                    imei = s.next();
                    System.out.println("Enter the phone's brand:");
                    brand = s.next();
                    System.out.println("Enter the phone's model:");
                    model = s.next();
                    System.out.println("Enter the phone's price:");
                    price = s.next();
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stt = c.createStatement();
                        stt.executeUpdate("INSERT INTO `smartphones`( `imei number`, `Brand`, `Model`, `Price`) VALUES(" + imei + ",'" + brand + "','" + model + "'," + price + ")");
                        System.out.println("Inserted successfully");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stt = c.createStatement();
                        ResultSet r = stt.executeQuery("SELECT `ID`, `imei number`, `Brand`, `Model`, `Price` FROM `smartphones` WHERE 1");
                        while (r.next()) {
                            System.out.println("\nID: " + r.getString("ID"));
                            System.out.println("imei number: " + r.getString("imei number"));
                            System.out.println("Brand: " + r.getString("Brand"));
                            System.out.println("Model: " + r.getString("Model"));
                            System.out.println("Price: " + r.getInt("Price"));
                        }
                    }
                    catch(Exception e){
                            System.out.println(e);
                        }
                        break;
                case 3:
                    try {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stt = c.createStatement();
                        ResultSet rs = stt.executeQuery("SELECT * FROM `smartphones` WHERE `Brand`= 'MI'");
                        while (rs.next()) {
                            System.out.println("\nID: " + rs.getString("ID"));
                            System.out.println("imei number: " + rs.getString("imei number"));
                            System.out.println("Brand: " + rs.getString("Brand"));
                            System.out.println("Model: " + rs.getString("Model"));
                            System.out.println("Price: " + rs.getInt("Price"));
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try{
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stt = c.createStatement();
                        stt.executeUpdate("UPDATE `smartphones` SET `Model` = '13ProMax' WHERE `imei number` = 741852963");
                        System.out.println("Updated successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    try{
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartphonedb?autoReconnect=true&useSSL=false", "root", "");
                        Statement stt = c.createStatement();
                        stt.executeUpdate("DELETE FROM `smartphones` WHERE `imei number`= 123456789");
                        System.out.println("Removed.");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("invalid entry.");
                    }
            }
        }
    }