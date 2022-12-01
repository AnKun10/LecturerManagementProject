package logic;

import main.Main;

import java.util.Scanner;

public class LoginFunction {

    public void login(Scanner scanner) {
        System.out.println("----LOGIN-----");
        System.out.println("Enter your Role you log in with: ");
        System.out.println("1 - Admin");
        System.out.println("2 - Lecturer");
        int choice;
        do {
            choice = Main.validator.getInt(scanner);
            if (( choice == 1 ) || (choice == 2)) {
                break;
            }
            System.out.println("You must choose number one or two!");
        } while (true);
        loginDecentralization(scanner, choice);
    }

    private void loginDecentralization(Scanner scanner, int choice) {
        switch (choice) {
            
        }
    }
}
