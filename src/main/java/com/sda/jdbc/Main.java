package com.sda.jdbc;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DBMenu dbMenu = new DBMenu();
        Connection connection = DBConnector.getConnection();

        String[] menu = new String[]{"1. Dodaj klienta", "2. Wyświetl klientów", "3. Edytuj klienta"};
        for (String s : menu) {
            System.out.println(s);
        }
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        switch (number) {
            case 1:
                System.out.println("Podaj imię:");
                String name = scanner.nextLine();
                System.out.println("Podaj nazwisko:");
                String surname = scanner.nextLine();
                System.out.println("Podaj adres:");
                String address = scanner.nextLine();
                System.out.println("Podaj kod pocztowy:");
                String code = scanner.nextLine();
                dbMenu.addCustomer(connection, name, surname, address, code);
                System.out.println("Dane zostały dodane");
                break;
            case 2:
                dbMenu.printCustomers(connection);
                break;
            case 3:
                System.out.println("Podaj imię osoby, której dane chcesz edytować:");
                String nameToEdit = scanner.nextLine();
                System.out.println("Podaj nazwisko osoby, której dane chcesz edytować:");
                String surnameToEdit = scanner.nextLine();
                dbMenu.deleteCustomer(connection, nameToEdit, surnameToEdit);
                System.out.println("Podaj nowe imię:");
                String newName = scanner.nextLine();
                System.out.println("Podaj nowe nazwisko:");
                String newSurname = scanner.nextLine();
                System.out.println("Podaj nowy adres:");
                String newAddress = scanner.nextLine();
                System.out.println("Podaj nowy kod pocztowy:");
                String newCode = scanner.nextLine();
                dbMenu.addCustomer(connection, newName, newSurname, newAddress, newCode);
                System.out.println("Dane zostały edytowane");
                break;
            default:
                System.out.println("Brak opcji");
        }
    }
}
