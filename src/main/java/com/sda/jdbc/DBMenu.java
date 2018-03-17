package com.sda.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMenu {

    public void addCustomer(Connection connection, String name, String surname, String address, String code) {
        try {
            String sql = "insert into customer(first_name, last_name, address, postal_code) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, code);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printCustomers(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from customer order by last_name asc";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.printf("%-10s | %-10s | %-15s | %-15s", "IMIĘ", "NAZWISKO", "ADRES", "KOD");
            System.out.println();
            while (resultSet.next()) {
                System.out.printf("%-10s | %-10s | %-15s | %-15s", resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("address"),
                        resultSet.getString("postal_code"));
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(Connection connection, String name, String surname) {
        try {
            String sql = "delete from customer where first_name ='" + name + "' and last_name = '" + surname + "'";
            PreparedStatement preparedStatement3 = connection.prepareStatement(sql);
            preparedStatement3.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
